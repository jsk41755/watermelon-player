package com.devjeong.watermelon_player.player


expect open class AudioPlayer() {
    fun play()
    fun pause()
    fun next()
    fun prev()
    fun play(songIndex: Int)
    fun seekTo(time: Double)
    fun addSongsUrls(songsUrl: List<String>)
    fun cleanUp()
}


