package com.devjeong.watermelon_player.player

import com.devjeong.watermelon_player.models.Music

interface PlayerEvents {
    fun onPlayPauseClick()
    fun onPreviousClick()
    fun onNextClick()
    fun onTrackClick(music: Music)
    fun onSeekBarPositionChanged(position: Long)
}