package com.devjeong.watermelon_player.di

import com.devjeong.watermelon_player.playlist.KtorMusicClient
import com.devjeong.watermelon_player.playlist.data.repository.MusicRepository
import com.devjeong.watermelon_player.playlist.data.repository.MusicRepositoryImpl
import com.devjeong.watermelon_player.playlist.presentation.MusicListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {

    single { KtorMusicClient.httpClient }

    single<MusicRepository> {
        MusicRepositoryImpl(httpClient = KtorMusicClient.httpClient)
    }

    factory { (coroutineScope: CoroutineScope?) ->
        MusicListViewModel(
            musicRepository = get(),
            coroutineScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)
        )
    }
}