package com.devjeong.watermelon_player.audioplayer.presentation

expect class MusicPlayer(playerState: PlayerState){
    fun play()
    fun pause()
    fun next()
    fun prev()
    fun play(songIndex: Int)
    fun seekTo(time: Double)
    fun addSongsUrls(songsUrl: List<String>)
    fun cleanUp()
}