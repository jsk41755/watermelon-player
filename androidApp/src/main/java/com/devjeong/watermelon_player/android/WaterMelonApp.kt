package com.devjeong.watermelon_player.android

import android.app.Application
import com.devjeong.watermelon_player.android.di.androidModule
import com.devjeong.watermelon_player.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WaterMelonApp : Application() {
    companion object {
        lateinit var app: Application
    }
    override fun onCreate() {
        super.onCreate()

        app = this

        startKoin {
            androidContext(this@WaterMelonApp)
            androidLogger()
            modules(appModule() + androidModule())
        }
    }
}