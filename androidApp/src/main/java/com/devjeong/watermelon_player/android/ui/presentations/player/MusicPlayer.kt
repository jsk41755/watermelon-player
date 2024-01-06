package com.devjeong.watermelon_player.android.ui.presentations.player

import androidx.media3.common.MediaItem
import com.devjeong.watermelon_player.android.WaterMelonApp
import com.devjeong.watermelon_player.player.CommonMusicPlayer

class MusicPlayer(private val commonMusicPlayer: CommonMusicPlayer) {

    fun initialize(trackList: MutableList<MediaItem>) {
        commonMusicPlayer.initialize(WaterMelonApp.app.applicationContext, trackList)
    }

    fun playPause() {
        commonMusicPlayer.play()
    }

    fun releasePlayer() {

    }
}