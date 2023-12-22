package com.devjeong.watermelon_player.audioplayer

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

class AudioObserver : ObserverProtocol, NSObject() {
    override fun observeValueForKeyPath(
        keyPath: String?,
        ofObject: Any?,
        change: Map<Any?, *>?,
        context: COpaquePointer?
    ) {
        println("keyPath $keyPath")
        println("ofObject $ofObject")
        println("change $change")
        println("context $context")
    }

}