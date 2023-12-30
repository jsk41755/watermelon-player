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

    fun toggleMusicLike(musicId: Int) {
        viewModelScope.launch {
            try {
                val music = findMusicById(musicId)
                music?.let {
                    musicRepository.toggleLike(musicId, !it.like)
                    // 로컬 상태 업데이트
                    _musicList.value = _musicList.value.map { m ->
                        if (m.id == musicId) m.copy(like = !m.like) else m
                    }
                }
            } catch (e: Exception) {
                println("Error toggling like: ${e.message}")
            }
        }
    }
}