package com.planting.online.onlineplanting.Activity

import android.net.Uri
import android.os.Bundle
import com.planting.online.onlineplanting.Entity.DataServiceResponse
import com.planting.online.onlineplanting.Entity.PlantingDataService
import com.planting.online.onlineplanting.R
import com.planting.online.onlineplanting.Utils.LogUtils

class MainActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PlantingDataService.getInstance().loginUser("15869355903","aq1sw2de",object: DataServiceResponse.Listener<Boolean>{
            override fun onResponse(response: Boolean) {
                val path = Uri.parse("file:///android_asset/logo.png")
                val newPath = path.toString()
                PlantingDataService.getInstance().updateUserProfile(1, "BlackMamba", "Jia Xing", "S", "15869355903", newPath, object : DataServiceResponse.Listener<Boolean> {
                    override fun onResponse(response: Boolean) {
                        LogUtils.d("user",response)
                    }
                }, object : DataServiceResponse.ErrorListener{
                    override fun onErrorResponse(error: Exception) {
                        assert(value = true)
                    }
                })
            }
        }, object : DataServiceResponse.ErrorListener{
            override fun onErrorResponse(error: Exception) {
                assert(value = true)
            }
        })
    }
}
