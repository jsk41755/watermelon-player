package com.devjeong.watermelon_player.android.di

import com.devjeong.watermelon_player.android.utils.PlayerUtil
import com.devjeong.watermelon_player.player.CommonMusicPlayer
import org.koin.dsl.module

val androidPlayerModule = module {
    single { CommonMusicPlayer() }
    single { PlayerUtil(get()) }
}