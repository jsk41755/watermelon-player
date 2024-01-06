package com.devjeong.watermelon_player.player

actual open class AudioPlayer {
    actual fun play() {
    }

    actual fun play(songIndex: Int) {
    }

    actual fun pause() {
    }

    actual fun next() {
    }

    actual fun prev() {
    }

    actual fun seekTo(time: Double) {
    }

    actual fun addSongsUrls(songsUrl: List<String>) {
    }

    actual fun cleanUp() {
    }
}