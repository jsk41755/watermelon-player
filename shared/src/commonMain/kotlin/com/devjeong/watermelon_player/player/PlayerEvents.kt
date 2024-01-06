package com.devjeong.watermelon_player.player

import com.devjeong.watermelon_player.models.Music

interface PlayerEvents {
    fun onPlayPauseClick()
    fun onPreviousClick(previousId: Int)
    fun onNextClick(nextId: Int)
    fun onTrackClick(music: Music)
    fun onSeekBarPositionChanged(position: Long)
}