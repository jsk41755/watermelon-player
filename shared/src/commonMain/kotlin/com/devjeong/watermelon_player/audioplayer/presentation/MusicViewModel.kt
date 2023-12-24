package com.devjeong.watermelon_player.audioplayer.presentation

import com.devjeong.watermelon_player.audioplayer.data.Music.MusicDto
import com.devjeong.watermelon_player.audioplayer.data.Music.MusicRepository
import com.devjeong.watermelon_player.audioplayer.domain.music.GetMusicListUseCase
import com.devjeong.watermelon_player.core.domain.util.CommonStateFlow
import com.devjeong.watermelon_player.core.domain.util.Resource
import com.devjeong.watermelon_player.core.domain.util.toCommonStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MusicViewModel(
    private val getMusicListUseCase: GetMusicListUseCase,
    private val coroutineScope: CoroutineScope? = null
) {
    private val _state = MutableStateFlow<Resource<List<MusicDto>>>(Resource.Success(emptyList()))
    val state: CommonStateFlow<Resource<List<MusicDto>>> = _state.toCommonStateFlow()

    fun fetchMusic() {
        coroutineScope?.launch {
            try {
                _state.value = Resource.Loading
                val musicList = getMusicListUseCase.invoke()
                _state.value = Resource.Success(musicList)
            } catch (e: Exception) {
                _state.value = Resource.Error(e)
            }
        } ?: run {
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    _state.value = Resource.Loading
                    val musicList = getMusicListUseCase.invoke()
                    _state.value = Resource.Success(musicList)
                } catch (e: Exception) {
                    _state.value = Resource.Error(e)
                }
            }
        }
    }
}

