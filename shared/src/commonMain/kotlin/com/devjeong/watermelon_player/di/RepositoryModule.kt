package com.devjeong.watermelon_player.di

import com.devjeong.watermelon_player.data.repositories.music.MusicRepository
import com.devjeong.watermelon_player.data.repositories.music.MusicRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MusicRepository> {
        MusicRepositoryImpl(httpClient = get())
    }
}