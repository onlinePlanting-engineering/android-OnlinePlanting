package com.planting.online.onlineplanting.networking

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
        val SERVICE_ENDPOINT = "http://ip.taobao.com/service"
    }

    @FormUrlEncoded
    @POST("/api/users/register/")
    fun userRegister(@Field("username") username: String, @Field("password") password: String): Call<ResponseBody>
}