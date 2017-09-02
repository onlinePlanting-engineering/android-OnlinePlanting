package com.planting.online.onlineplanting.Networking

import android.content.Context
import com.planting.online.onlineplanting.Constant.PlantingConstant
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by eleven on 2017/8/30.
 */
class PlantingRetrofitManager private constructor(){

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
            mOkHttpClient = OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build()
        }
    }

    private  fun createRetrifit() {
        var retrofit = Retrofit.Builder()
                .baseUrl(PlantingConstant.SERVER_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        mPlantingServices = retrofit.create(PlantingServices::class.java)
    }

    fun registerUser(username: String, password: String, callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.registerUser(username, password)
        call?.enqueue(callback)
    }

    fun loginUser(username: String, password: String, callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.loginUser(username, password)
        call?.enqueue(callback)

    }
}