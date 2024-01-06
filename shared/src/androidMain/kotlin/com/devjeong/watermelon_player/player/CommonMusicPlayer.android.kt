package com.devjeong.watermelon_player.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer

actual class CommonMusicPlayer actual constructor() : Player.Listener {
    lateinit var player: ExoPlayer

    fun initialize(context: Context, trackList: MutableList<MediaItem>) {
        player = ExoPlayer.Builder(context).build()

        player.addListener(this)
        player.setMediaItems(trackList)
        player.prepare()
    }

    actual fun play() {
        // TODO; 재생 정지다
        if (player.playbackState == Player.STATE_IDLE) player.prepare()
        player.playWhenReady = !player.playWhenReady
    }

    actual fun pause() {
        if (this::player.isInitialized){
            player.playWhenReady = false
        }
    }

    actual fun next() {
    }

    actual fun prev() {
    }

    actual fun play(songIndex: Int) {
        if (songIndex >= 0 && songIndex < player.mediaItemCount) {
            player.seekTo(songIndex, 0)
            player.playWhenReady = true
        }
    }

    actual fun seekTo(time: Double) {
    }

    actual fun addSongsUrls(songsUrl: List<String>) {
    }

    actual fun cleanUp() {
    }
}