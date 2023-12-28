package com.devjeong.watermelon_player.playlist.presentation

import com.devjeong.watermelon_player.playlist.data.repository.MusicRepository
import com.devjeong.watermelon_player.playlist.model.Music
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class MusicListViewModel(
    private val musicRepository: MusicRepository,
    private val coroutineScope: CoroutineScope? = null
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _musicList: MutableStateFlow<List<Music>> = MutableStateFlow(emptyList())
    val musicList: StateFlow<List<Music>> = _musicList.asStateFlow()

    init {
        fetchMusicList()
    }

    private fun fetchMusicList() {
        viewModelScope.launch {
            try {
                val fetchedMusic = musicRepository.fetchMusicList()
                _musicList.value = fetchedMusic

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}