package com.devjeong.watermelon_player

import com.devjeong.watermelon_player.di.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    val koinApp = startKoin {
        modules(appModule())
    }.koin

}