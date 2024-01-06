package com.devjeong.watermelon_player.android.ui.presentations.player

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.media3.common.MediaItem
import androidx.media3.extractor.mp4.Track
import com.devjeong.watermelon_player.android.ui.presentations.BaseViewModel
import com.devjeong.watermelon_player.models.Music
import com.devjeong.watermelon_player.player.PlayerEvents

class PlayViewModel(
    private val musicPlayer: MusicPlayer
) : BaseViewModel(), PlayerEvents {
    private var trackList: List<Music> = listOf()

    private val _tracks = mutableStateListOf<Track>()
    private var selectedTrackIndex: Int by mutableIntStateOf(-1)
    private var isTrackPlay: Boolean = false
    private var isAuto: Boolean = false

    fun initialize(musicList: List<Music>) {
        trackList = musicList
        musicPlayer.initialize(musicList.toMediaItemList())
    }

    private fun playMusicById(musicId: Int) {
        val index = trackList.indexOfFirst { it.id == musicId }
        Log.d("index", index.toString())
        if (index != -1) {
            musicPlayer.play(index)
        }
    }

    fun stopAndPlayMusicById(musicId: Int) {
        // 현재 재생 중인 노래 정지
        musicPlayer.pause()

        // 새로운 노래 재생
        playMusicById(musicId)
    }

    override fun onPlayPauseClick() {
        musicPlayer.playPause()
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
            musicPlayer.play(index)
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
       // musicPlayer.releasePlayer()
    }
}

fun List<Music>.toMediaItemList(): MutableList<MediaItem> {
    return this.map { MediaItem.fromUri(it.streamUrl) }.toMutableList()
}