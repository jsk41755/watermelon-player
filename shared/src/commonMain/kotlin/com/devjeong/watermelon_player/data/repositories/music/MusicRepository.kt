package com.devjeong.watermelon_player.data.repositories.music

import com.devjeong.watermelon_player.models.Music

interface MusicRepository {
    suspend fun fetchMusicList(): List<Music>

    suspend fun fetchLikeMusicList(): List<Music>
    suspend fun toggleLike(id: Int, like: Boolean)
}
