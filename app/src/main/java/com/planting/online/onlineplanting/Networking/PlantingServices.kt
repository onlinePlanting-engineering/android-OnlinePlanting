package com.planting.online.onlineplanting.Networking

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by eleven on 2017/8/29.
 */
interface PlantingServices {

    companion object {
        val SERVICE_ENDPOINT = "http://192.168.1.104:8000"
    }

    @FormUrlEncoded
    @POST(PlantingWebServiceMapping.UserRegistraion)
    fun registerUser(@Field("username") username: String, @Field("password") password: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST(PlantingWebServiceMapping.UserLogin)
    fun loginUser(@Field("username") username: String, @Field("password") password: String): Call<ResponseBody>
}