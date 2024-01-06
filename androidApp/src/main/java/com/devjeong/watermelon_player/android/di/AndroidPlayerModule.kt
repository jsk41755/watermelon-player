package com.devjeong.watermelon_player.android.di

import androidx.media3.exoplayer.ExoPlayer
import com.devjeong.watermelon_player.android.WaterMelonApp
import com.devjeong.watermelon_player.android.ui.presentations.player.MusicPlayer
import org.koin.dsl.module

val androidPlayerModule = module {
    single { ExoPlayer.Builder(WaterMelonApp.app.applicationContext).build() }
    single { MusicPlayer(get()) }
}