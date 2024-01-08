package com.devjeong.watermelon_player.player

actual class CommonMusicPlayer actual constructor() {
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

    actual fun seekTo(time: Long) {
}

    actual fun addSongsUrls(songsUrl: List<String>) {
    }

    actual fun cleanUp() {
    }

    actual fun isPlaying(): Boolean {
        return false // TEST;
    }
}