package com.devjeong.watermelon_player.player

import platform.AVFoundation.AVPlayerItem

actual class Player actual constructor() {
    private val playerItems = mutableListOf<AVPlayerItem>()

    actual fun play() {
    }

    actual fun pause() {
    }

    actual fun next() {
    }

    actual fun prev() {
    }

    actual fun play(songIndex: Int) {
    }

    actual fun seekTo(time: Double) {
    }

    actual fun addSongsUrls(songsUrl: List<String>) {
    }

    actual fun cleanUp() {
    }
}