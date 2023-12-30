package com.devjeong.watermelon_player.android.ui.presentations.playlist

import androidx.lifecycle.viewModelScope
import com.devjeong.watermelon_player.android.ui.presentations.BaseViewModel
import com.devjeong.watermelon_player.presentations.MusicListViewModel
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class PlayListViewModel : BaseViewModel() {
    val musicListViewModel: MusicListViewModel by inject { parametersOf(viewModelScope) }
}