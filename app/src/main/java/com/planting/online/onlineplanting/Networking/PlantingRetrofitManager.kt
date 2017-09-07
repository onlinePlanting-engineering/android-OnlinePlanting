package com.planting.online.onlineplanting.Networking

import android.content.Context
import com.planting.online.onlineplanting.App.PlantingApplication
import com.planting.online.onlineplanting.Constant.PlantingConstant
import com.planting.online.onlineplanting.Utils.SharedPreferencesHelper
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Part
import retrofit2.http.Path
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
                val token = SharedPreferencesHelper.getDataString(PlantingApplication.getInstance().getContext(),PlantingConstant.PLANTING_PREFERENCE,PlantingConstant.TOKEN,null)
                token.let {
                    return chain?.proceed(request
                            ?.addHeader("Content-Type", "multipart/form-data")
                            ?.addHeader("Authorization","Token $token")
                            ?.method(original.method(), original.body())
                            ?.build())
                }
            }
            request?.build()?.url().toString().contains(PlantingWebServiceMapping.CreateComment) -> {
                val token = SharedPreferencesHelper.getDataString(PlantingApplication.getInstance().getContext(),PlantingConstant.PLANTING_PREFERENCE,PlantingConstant.TOKEN,null)
                token.let {
                    return chain?.proceed(request
                            ?.addHeader("Authorization","Token $token")
                            ?.method(original.method(), original.body())
                            ?.build())
                }
            }
            else -> {
                val token = SharedPreferencesHelper.getDataString(PlantingApplication.getInstance().getContext(),PlantingConstant.PLANTING_PREFERENCE,PlantingConstant.TOKEN,null)
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

    fun getComments(type: String, id: Long,callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.getComments(type, id)
        call?.enqueue(callback)
    }

    fun getParentComments(id: Long,callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.getParentComments(id)
        call?.enqueue(callback)
    }

    fun createComment(type: String, id: Long, parent_id: Long?, content: String, grade: String, callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.createComment(type, id, parent_id, content, grade)
        call?.enqueue(callback)
    }

    fun getImagesByGroup(id: Long, callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.getImagesByGroup(id)
        call?.enqueue(callback)
    }

    fun getLandsInforById(id: Long, callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.getLandsInforById(id)
        call?.enqueue(callback)
    }

    fun getSeedCategories(callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.getSeedCategories()
        call?.enqueue(callback)
    }

    fun updateUserProfile(userId: Long, nickname: RequestBody, addr: RequestBody, gender: RequestBody, username: RequestBody, image: RequestBody, callback: Callback<ResponseBody>) {
        val call = mPlantingServices?.updateUserProfile(userId, image, nickname, addr, gender, username)
        call?.enqueue(callback)
    }
}