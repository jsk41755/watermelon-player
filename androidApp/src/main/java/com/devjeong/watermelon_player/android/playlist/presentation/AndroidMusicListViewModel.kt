package com.devjeong.watermelon_player.android.playlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjeong.watermelon_player.playlist.presentation.MusicListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class AndroidMusicListViewModel : ViewModel(), KoinComponent {

    val musicListViewModel: MusicListViewModel by inject { parametersOf(viewModelScope) }
}