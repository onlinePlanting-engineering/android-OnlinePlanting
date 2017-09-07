package com.planting.online.onlineplanting.Activity

import android.content.Intent
import android.os.Bundle
import com.planting.online.onlineplanting.Entity.DataServiceResponse
import com.planting.online.onlineplanting.Entity.PlantingDataService
import com.planting.online.onlineplanting.R
import com.planting.online.onlineplanting.Utils.LogUtils
import com.zzti.fengyongge.imagepicker.PhotoSelectorActivity


class MainActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PlantingDataService.getInstance().loginUser("15869355903","aq1sw2de",object: DataServiceResponse.Listener<Boolean>{
            override fun onResponse(response: Boolean) {
                val intent = Intent(this@MainActivity, PhotoSelectorActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                intent.putExtra("limit", 1)
                startActivityForResult(intent, 0)
            }
        }, object : DataServiceResponse.ErrorListener{
            override fun onErrorResponse(error: Exception) {
                assert(value = true)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> if (data != null) {
                val paths = data.extras.getSerializable("photos") as List<String>
                println(paths)
                if (paths.size == 1) {
                    val imagePath = paths.first()
                    PlantingDataService.getInstance().updateUserProfile(1, "BlackMamba", "Jia Xing", "M", "15869355903", imagePath, object : DataServiceResponse.Listener<Boolean> {
                    override fun onResponse(response: Boolean) {
                        LogUtils.d("user",response)
                    }
                }, object : DataServiceResponse.ErrorListener{
                    override fun onErrorResponse(error: Exception) {
                        assert(value = true)
                    }
                })
                }
            }
            else -> {
            }
        }
    }
}
