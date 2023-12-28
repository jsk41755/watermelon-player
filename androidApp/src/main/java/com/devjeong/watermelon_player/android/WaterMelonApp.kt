package com.devjeong.watermelon_player.android

import android.app.Application
import com.devjeong.watermelon_player.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WaterMelonApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WaterMelonApp)
            androidLogger()
            modules(appModule)
        }
    }
}