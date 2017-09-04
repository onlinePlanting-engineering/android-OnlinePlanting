package com.planting.online.onlineplanting.Networking

import android.provider.SyncStateContract
import com.planting.online.onlineplanting.App.PlantingApplication
import com.planting.online.onlineplanting.Constant.PlantingConstant
import com.planting.online.onlineplanting.Utils.SharedPreferencesHelper
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
            val token = SharedPreferencesHelper.getDataString(PlantingApplication.getInstance().applicationContext, PlantingConstant.VANTAGE_PREFERENCE,"token","")
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
}