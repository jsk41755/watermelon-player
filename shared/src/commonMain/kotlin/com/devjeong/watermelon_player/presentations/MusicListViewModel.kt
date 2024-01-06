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

    private val _likedMusicList: MutableStateFlow<List<Music>> = MutableStateFlow(emptyList())
    val likedMusicList: StateFlow<List<Music>> = _likedMusicList.asStateFlow()

    init {
        fetchMusicList()
        fetchLikeMusicList()
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

    private fun fetchLikeMusicList() {
        viewModelScope.launch {
            try {
                val fetchedLikeMusic = musicRepository.fetchLikeMusicList()
                _likedMusicList.value = fetchedLikeMusic
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
            fetchLikeMusicList()
        }
    }

    fun findNextSongId(currentSongId: Int): Int {
        val currentSongIndex = musicList.value.indexOfFirst { it.id == currentSongId }
        return if (currentSongIndex == -1 || currentSongIndex == musicList.value.size - 1) {
            musicList.value[0].id
        } else {
            musicList.value[currentSongIndex + 1].id
        }
    }

    fun findPreviousSongId(currentSongId: Int): Int {
        val currentSongIndex = musicList.value.indexOfFirst { it.id == currentSongId }
        return if (currentSongIndex == 0 || currentSongIndex == musicList.value.size - 1) {
            musicList.value[0].id
        } else {
            musicList.value[currentSongIndex - 1].id
        }
    }
}