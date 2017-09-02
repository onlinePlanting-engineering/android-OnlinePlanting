package com.planting.online.onlineplanting

import com.planting.online.onlineplanting.Entity.DataServiceResponse
import com.planting.online.onlineplanting.Entity.PlantingDataService
import org.junit.Test

/**
 * Created by eleven on 2017/9/2.
 */

class TestNetworkingClass {

    @Test
    fun testloginUserAPI() {
        PlantingDataService.getInstance().loginUser("15869355903","aq1sw2de",object: DataServiceResponse.Listener<Boolean>{
            override fun onResponse(response: Boolean) {
                assert(response)
            }
        }, object : DataServiceResponse.ErrorListener{
            override fun onErrorResponse(error: Exception) {
                assert(value = true)
            }
        })
    }
}