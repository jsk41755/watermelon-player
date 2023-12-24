package com.devjeong.watermelon_player.audioplayer.presentation

import kotlinx.cinterop.CValue
import kotlinx.cinterop.*
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryPlayback
import platform.AVFAudio.setActive
import platform.AVFoundation.*
import platform.CoreMedia.CMTime
import platform.CoreMedia.CMTimeGetSeconds
import platform.CoreMedia.CMTimeMakeWithSeconds
import platform.Foundation.*
import platform.darwin.Float64
import platform.darwin.NSEC_PER_SEC
import platform.darwin.NSObject
import kotlin.time.DurationUnit
import kotlin.time.toDuration

// iosMain
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.Foundation.NSURL
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.native.concurrent.freeze
@OptIn(ExperimentalForeignApi::class)
actual class MusicPlayer actual constructor(private val playerState: PlayerState) {
    private val player = AVPlayer()

    actual fun play() {
        player.play()
        updatePlayerState(isPlaying = true)
    }

    actual fun pause() {
        player.pause()
        updatePlayerState(isPlaying = false)
    }

    actual fun next() {
        // iOS 특화 다음 곡 재생 로직
    }

    actual fun prev() {
        // iOS 특화 이전 곡 재생 로직
    }

    actual fun play(songIndex: Int) {
        // 특정 인덱스의 곡을 재생하는 로직
    }

    actual fun seekTo(time: Double) {
        val seekTime = CMTimeMakeWithSeconds(time, preferredTimescale = 1)
        player.seekToTime(seekTime)
    }

    actual fun addSongsUrls(songsUrl: List<String>) {
        // songsUrl 리스트를 사용하여 재생 목록을 구성하는 로직
    }

    actual fun cleanUp() {
        player.pause()
        player.replaceCurrentItemWithPlayerItem(null)
    }

    private fun updatePlayerState(isPlaying: Boolean) {
        dispatch_async(dispatch_get_main_queue()) {
            playerState.isPlaying = isPlaying
            playerState.freeze()
        }
    }
}
