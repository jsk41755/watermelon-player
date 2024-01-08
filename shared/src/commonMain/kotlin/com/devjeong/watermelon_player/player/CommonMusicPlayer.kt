package com.devjeong.watermelon_player.player

expect class CommonMusicPlayer(){
    fun play()
    fun pause()
    fun next()
    fun prev()
    fun play(songIndex: Int)
    fun seekTo(time: Long)
    fun addSongsUrls(songsUrl: List<String>)
    fun cleanUp()
    fun isPlaying(): Boolean
}