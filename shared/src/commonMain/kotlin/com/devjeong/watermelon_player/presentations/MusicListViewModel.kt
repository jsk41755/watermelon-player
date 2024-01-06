package com.devjeong.watermelon_player.presentations

import com.devjeong.watermelon_player.data.repositories.music.MusicRepository
import com.devjeong.watermelon_player.models.Music
import com.devjeong.watermelon_player.player.AudioPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MusicListViewModel(
    private val musicRepository: MusicRepository,
    private val coroutineScope: CoroutineScope? = null
): AudioPlayer() {
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

    fun toggleMusicLike(musicId: Int) {
        viewModelScope.launch {
            val updatedList = _musicList.value.map { music ->
                if (music.id == musicId) {
                    musicRepository.toggleLike(music.id, !music.like)
                    music.copy(like = !music.like)
                } else music
            }
            _musicList.value = updatedList
        }
    }
}