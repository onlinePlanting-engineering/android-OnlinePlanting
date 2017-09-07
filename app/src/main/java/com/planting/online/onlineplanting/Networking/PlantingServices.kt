package com.planting.online.onlineplanting.Networking

import android.provider.SyncStateContract
import com.planting.online.onlineplanting.App.PlantingApplication
import com.planting.online.onlineplanting.Constant.PlantingConstant
import com.planting.online.onlineplanting.Utils.SharedPreferencesHelper
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

/**
 * Created by eleven on 2017/8/29.
 */
interface PlantingServices {

    companion object {
        val SERVICE_ENDPOINT = "http://192.168.0.4:8000"

        fun getToken(): String? {
            val token = SharedPreferencesHelper.getDataString(PlantingApplication.getInstance().applicationContext, PlantingConstant.PLANTING_PREFERENCE,"token","")
            return token
        }
    }

    @FormUrlEncoded
    @POST(PlantingWebServiceMapping.UserRegistraion)
    fun registerUser(@Field("username") username: String, @Field("password") password: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST(PlantingWebServiceMapping.UserLogin)
    fun loginUser(@Field("username") username: String, @Field("password") password: String): Call<ResponseBody>

    @GET(PlantingWebServiceMapping.GetUserProfile)
    fun getUserProfile(): Call<ResponseBody>

    @GET(PlantingWebServiceMapping.GetFarmList)
    fun getFarmList():Call<ResponseBody>

    @GET(PlantingWebServiceMapping.GetComments)
    fun getComments(@Query("type") type: String, @Query("id") id: Long): Call<ResponseBody>

    @GET(PlantingWebServiceMapping.GetComments + "{id}")
    fun getParentComments(@Path("id") id: Long): Call<ResponseBody>

    @FormUrlEncoded
    @POST(PlantingWebServiceMapping.CreateComment)
    fun createComment(@Query("type") type: String, @Query("id") id: Long,@Query("parent_id") parent_id: Long?, @Field("content") content: String, @Field("grade") grade: String): Call<ResponseBody>

    @GET(PlantingWebServiceMapping.GetImageByGroup + "{id}")
    fun getImagesByGroup(@Path("id") id: Long): Call<ResponseBody>

    @GET(PlantingWebServiceMapping.GetLandsById + "{id}")
    fun getLandsInforById(@Path("id") id: Long): Call<ResponseBody>

    @GET(PlantingWebServiceMapping.GetSeedCategories)
    fun getSeedCategories(): Call<ResponseBody>

    @Multipart
    @POST(PlantingWebServiceMapping.UpdateUserProfile + "{id}")
    fun updateUserProfile(@Path("id") userId: Long, @Part("profile.img_heading") image: RequestBody, @Part("profile.nickname") nickname: RequestBody, @Part("profile.addr") addr: RequestBody, @Part("profile.gender") gender: RequestBody, @Part("username") username: RequestBody): Call<ResponseBody>
}