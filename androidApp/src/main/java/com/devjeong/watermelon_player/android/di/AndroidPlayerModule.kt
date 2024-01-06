package com.devjeong.watermelon_player.android.di

import com.devjeong.watermelon_player.android.ui.presentations.player.MusicPlayer
import com.devjeong.watermelon_player.player.CommonMusicPlayer
import org.koin.dsl.module

val androidPlayerModule = module {
    single { CommonMusicPlayer() }
    single { MusicPlayer(get()) }
}