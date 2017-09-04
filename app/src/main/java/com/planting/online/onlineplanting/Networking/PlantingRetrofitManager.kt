package com.planting.online.onlineplanting.Networking

import android.content.Context
import com.planting.online.onlineplanting.App.PlantingApplication
import com.planting.online.onlineplanting.Constant.PlantingConstant
import com.planting.online.onlineplanting.Utils.SharedPreferencesHelper
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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

    override fun intercept(chain: Interceptor.Chain?): Response? {
        val original = chain?.request()
        val request = original?.newBuilder()
        when {
            //without token
            request?.build()?.url().toString().contains(PlantingWebServiceMapping.UserLogin) -> {
                return chain?.proceed(request
                        ?.method(original.method(), original.body())
                        ?.build())
            }
            request?.build()?.url().toString() == PlantingWebServiceMapping.UpdateUserProfile -> {
                val token = SharedPreferencesHelper.getDataString(PlantingApplication.getInstance().getContext(),PlantingConstant.VANTAGE_PREFERENCE,PlantingConstant.TOKEN,null)
                token.let {
                    return chain?.proceed(request
                            ?.addHeader("Content-Type", "multipart/form-data")
                            ?.addHeader("Authorization","Token $token")
                            ?.method(original.method(), original.body())
                            ?.build())
                }
            }
            else -> {
                val token = SharedPreferencesHelper.getDataString(PlantingApplication.getInstance().getContext(),PlantingConstant.VANTAGE_PREFERENCE,PlantingConstant.TOKEN,null)
                token.let {
                    return chain?.proceed(request
                            ?.addHeader("Content-Type", "application/json")
                            ?.addHeader("Allow","POST,OPTIONS")
                            ?.addHeader("Authorization","Token $token")
                            ?.method(original.method(), original.body())
                            ?.build())
                }

            }
        }
        return null
    }

    private fun getLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    private fun createOkHttpClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(getLogInterceptor()).readTimeout(100000, TimeUnit.SECONDS).connectTimeout(100000, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .addNetworkInterceptor(this)
                    .build()
        }
    }

    private  fun createRetrifit() {
        var retrofit = Retrofit.Builder()
                .baseUrl(PlantingConstant.SERVER_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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

    fun getUserProfile(callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.getUserProfile()
        call?.enqueue(callback)
    }

    fun getFarmList(callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.getFarmList()
        call?.enqueue(callback)
    }
}