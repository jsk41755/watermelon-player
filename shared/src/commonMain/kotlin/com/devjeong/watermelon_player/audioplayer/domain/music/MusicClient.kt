package com.devjeong.watermelon_player.audioplayer.domain.music

import com.devjeong.watermelon_player.audioplayer.data.Music.MusicDto

interface MusicClient {
    suspend fun getMusicList(): List<MusicDto>
}