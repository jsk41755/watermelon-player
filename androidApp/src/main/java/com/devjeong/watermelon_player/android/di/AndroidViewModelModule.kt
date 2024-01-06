package com.devjeong.watermelon_player.android.di

import com.devjeong.watermelon_player.android.ui.presentations.player.PlayViewModel
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidViewModelModule = module {
    viewModel { PlayListViewModel() }
    viewModel { PlayViewModel(get()) }
}