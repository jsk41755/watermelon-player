package com.devjeong.watermelon_player.audioplayer.domain.music

import com.devjeong.watermelon_player.audioplayer.data.Music.MusicDto
import com.devjeong.watermelon_player.audioplayer.data.Music.MusicRepository

class GetMusicListUseCase(private val musicRepository: MusicRepository) {
    suspend operator fun invoke(): List<MusicDto> {
        return musicRepository.getMusicList()
    }
}
