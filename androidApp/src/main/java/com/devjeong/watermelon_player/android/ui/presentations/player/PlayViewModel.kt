package com.devjeong.watermelon_player.android.ui.presentations.player

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
    private val musicPlayer: MusicPlayer,
) : BaseViewModel(), PlayerEvents {
    private val _tracks = mutableStateListOf<Track>()
    private var selectedTrackIndex: Int by mutableIntStateOf(-1)
    private var isTrackPlay: Boolean = false
    private var isAuto: Boolean = false

    fun initialize(trackList: MutableList<MediaItem>) {
        musicPlayer.iniPlayer(trackList)
        observePlayerState()
    }

    private fun observePlayerState() {
        // TODO;
    }

    override fun onPlayPauseClick() {
        musicPlayer.playPause()
    }

    override fun onPreviousClick() {
        // TODO;
    }

    override fun onNextClick() {
        // TODO;
    }

    override fun onTrackClick(music: Music) {
        // do nothing
    }

    private fun setUpTrack() {
        if (!isAuto) musicPlayer.setUpTrack(selectedTrackIndex, isTrackPlay)
        isAuto = false
    }

    override fun onSeekBarPositionChanged(position: Long) {
        // TODO;
    }

    override fun onCleared() {
        super.onCleared()
        musicPlayer.releasePlayer()
    }
}

fun List<Music>.toMediaItemList(): MutableList<MediaItem> {
    return this.map { MediaItem.fromUri(it.streamUrl) }.toMutableList()
}