package com.planting.online.onlineplanting.App

import android.app.Application
import android.content.Context
import android.util.Log
import com.planting.online.onlineplanting.Utils.LogUtils

/**
 * Created by eleven on 2017/8/30.
 */
class PlantingApplication: Application() {

    fun getContext(): Context? {
        return mContext
    }

    companion object {
        private @Volatile var mInstance: PlantingApplication? = null
        private var mContext: Context? = null

        fun getInstance(): PlantingApplication {
            return Holder.INSTANCE
        }
    }

    private object Holder {
        val INSTANCE = PlantingApplication()
    }

    override fun onCreate() {
        super.onCreate()
        LogUtils.getSettings().setLogEnable(true)
        LogUtils.getSettings().setLogLevel(Log.DEBUG)
        mInstance = this
        mContext = getApplicationContext()
    }
}
