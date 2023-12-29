package com.devjeong.watermelon_player.presentations

import com.devjeong.watermelon_player.data.repositories.music.MusicRepository
import com.devjeong.watermelon_player.models.Music
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    fun findMusicById(musicId: Int): Music? {
        return _musicList.value.firstOrNull { it.id == musicId }
    }
}