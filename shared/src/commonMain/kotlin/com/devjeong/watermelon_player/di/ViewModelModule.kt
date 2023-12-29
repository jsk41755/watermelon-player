package com.devjeong.watermelon_player.di

import com.devjeong.watermelon_player.presentations.MusicListViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MusicListViewModel(musicRepository = get()) }
}