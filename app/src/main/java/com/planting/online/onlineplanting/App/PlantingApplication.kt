package com.planting.online.onlineplanting.App

import android.app.Application

/**
 * Created by eleven on 2017/8/30.
 */
class PlantingApplication: Application() {

    private @Volatile var instance: PlantingApplication? = null

    companion object {
        fun getInstance(): PlantingApplication {
            return Holder.INSTANCE
        }
    }

    private object Holder { val INSTANCE = PlantingApplication() }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}