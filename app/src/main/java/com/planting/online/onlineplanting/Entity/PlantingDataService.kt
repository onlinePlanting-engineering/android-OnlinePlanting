package com.planting.online.onlineplanting.Entity

import com.planting.online.onlineplanting.Networking.PlantingRetrofitManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by eleven on 2017/9/1.
 */
class PlantingDataService {

    companion object {
        fun getInstance(): PlantingDataService {
            return Holder.INSTANCE
        }
    }

    private object Holder { val INSTANCE = PlantingDataService() }

    fun registerUser(username: String, password: String, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().registerUser(username, password, object: Callback<ResponseBody> {

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                TODO("not implemented")
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                TODO("not implemented")
            }
        })
    }

    fun loginUser(username: String, password: String, listener: DataServiceResponse.Listener<Boolean>, errorListener: DataServiceResponse.ErrorListener) {
        PlantingRetrofitManager.getInstance().loginUser(username, password, object : Callback<ResponseBody>{

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                println("failed")
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                println("success")
            }
        })
    }

}