package com.devjeong.watermelon_player.android.utils

import androidx.media3.common.MediaItem
import com.devjeong.watermelon_player.android.WaterMelonApp
import com.devjeong.watermelon_player.player.CommonMusicPlayer

class PlayerUtil(val commonMusicPlayer: CommonMusicPlayer) {

    fun initialize(trackList: MutableList<MediaItem>) {
        commonMusicPlayer.initialize(WaterMelonApp.app.applicationContext, trackList)
    }
}