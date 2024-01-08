package com.devjeong.watermelon_player.android.ui.presentations.player

import android.util.Log
import com.devjeong.watermelon_player.android.extensions.toMediaItemList
import com.devjeong.watermelon_player.android.ui.presentations.BaseViewModel
import com.devjeong.watermelon_player.android.utils.PlayerUtil
import com.devjeong.watermelon_player.models.Music
import com.devjeong.watermelon_player.player.PlayerEvents

class PlayViewModel(
    val playerUtil: PlayerUtil
) : BaseViewModel(), PlayerEvents {
    private var trackList: List<Music> = listOf()
    private var currentPlayingSongId: Int? = null

    fun initialize(musicList: List<Music>) {
        trackList = musicList
        playerUtil.initialize(trackList.toMediaItemList())
    }

    fun playNewSong(musicId: Int) {
        if (currentPlayingSongId != musicId) {
            Log.d("currentPlayingSongId", currentPlayingSongId.toString())
            Log.d("currentPlayingSongId", musicId.toString())
            // 새 노래 재생
            currentPlayingSongId = musicId
            playMusicById(musicId)
        }
    }

    private fun playMusicById(musicId: Int) {
        if (playerUtil.commonMusicPlayer.isPlaying()) {
            playerUtil.commonMusicPlayer.pause()
        }

        val index = trackList.indexOfFirst { it.id == musicId }
        Log.d("index", index.toString())
        if (index != -1) {
            playerUtil.commonMusicPlayer.play(index)
        }
    }

    fun stopAndPlayMusicById(musicId: Int) {
        // 현재 재생 중인 노래 정지
        playerUtil.commonMusicPlayer.pause()
        // 새로운 노래 재생
        playMusicById(musicId)
    }

    override fun onPlayPauseClick() {
        if (playerUtil.commonMusicPlayer.isPlaying()) {
            playerUtil.commonMusicPlayer.pause()
        } else {
            playerUtil.commonMusicPlayer.play()
        }
    }

    override fun onPreviousClick(previousId: Int) {
        stopAndPlayMusicById(previousId)
    }

    override fun onNextClick(nextId: Int) {
        stopAndPlayMusicById(nextId)
    }

    override fun onTrackClick(music: Music) {
        val index = trackList.indexOf(music)
        if (index != -1) {
            playerUtil.commonMusicPlayer.play(index)
        }
    }

    private fun setUpTrack() {
        // TODO;
    }

    override fun onSeekBarPositionChanged(position: Long) {
        // TODO;
    }

    override fun onCleared() {
        super.onCleared()
        playerUtil.commonMusicPlayer.cleanUp()
    }
}