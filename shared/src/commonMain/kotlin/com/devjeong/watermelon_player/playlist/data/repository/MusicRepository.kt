package com.devjeong.watermelon_player.playlist.data.repository

import com.devjeong.watermelon_player.playlist.model.Music

interface MusicRepository {
    suspend fun fetchMusicList(): List<Music>
}
