package com.devjeong.watermelon_player

import android.app.Application
import android.content.Context

class WaterMelonApp : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

}