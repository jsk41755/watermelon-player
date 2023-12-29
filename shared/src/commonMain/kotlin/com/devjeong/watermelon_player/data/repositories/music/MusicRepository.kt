package com.devjeong.watermelon_player.data.repositories.music

import com.devjeong.watermelon_player.models.Music

interface MusicRepository {
    suspend fun fetchMusicList(): List<Music>
}
