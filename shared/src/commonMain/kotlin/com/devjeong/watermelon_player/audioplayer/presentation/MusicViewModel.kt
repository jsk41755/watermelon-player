package com.devjeong.watermelon_player.audioplayer.presentation

import com.devjeong.watermelon_player.audioplayer.data.Music.MusicDto
import com.devjeong.watermelon_player.audioplayer.data.Music.MusicRepository
import com.devjeong.watermelon_player.audioplayer.domain.music.GetMusicListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MusicViewModel(
    private val getMusicListUseCase: GetMusicListUseCase,
    private val coroutineScope: CoroutineScope?
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _musicList = MutableStateFlow<List<MusicDto>>(emptyList())
    val musicList: StateFlow<List<MusicDto>> = _musicList.asStateFlow()

    suspend fun loadMusicList() {
        try {
            // getMusicListUseCase를 통해 데이터를 가져오는 비즈니스 로직
            val musicListData = getMusicListUseCase()

            // 데이터 업데이트
            _musicList.value = musicListData
        } catch (e: Exception) {
            // 에러 처리
        }
    }
}
