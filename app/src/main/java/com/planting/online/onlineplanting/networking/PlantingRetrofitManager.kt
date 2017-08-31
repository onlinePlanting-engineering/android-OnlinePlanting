package com.planting.online.onlineplanting.networking

import android.content.Context
import com.planting.online.onlineplanting.App.PlantingApplication
import com.planting.online.onlineplanting.Constants.PlantingConstant
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by eleven on 2017/8/30.
 */
class PlantingRetrofitManager private constructor(): Interceptor {

    private var mContext: Context? = null
    private var mPlantingServices: PlantingServices? = null
    private var mOkHttpClient: OkHttpClient? = null

    companion object {
        fun getInstance(): PlantingRetrofitManager {
            return Holder.INSTANCE
        }
    }

    private object Holder { val INSTANCE = PlantingRetrofitManager() }

    init {
        createOkHttpClient()
        createRetrifit()
    }

    private fun createOkHttpClient() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        if (mOkHttpClient == null) {
            val cache = Cache(File(PlantingApplication.getInstance().cacheDir, "Planting_Cache"), 14 * 1024 * 100)
            mOkHttpClient = OkHttpClient.Builder()
                    .cache(cache)
                    .retryOnConnectionFailure(true)
                    .addNetworkInterceptor(this)
                    .addInterceptor(this)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build()
        }
    }

    private  fun createRetrifit() {
        var retrofit = Retrofit.Builder()
                .baseUrl(PlantingConstant.SERVER_BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        mPlantingServices = retrofit.create(PlantingServices::class.java)
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    public fun registerUser(username: String, password: String): Call<ResponseBody>?{
        return mPlantingServices?.registerUser(username, password)
    }
}