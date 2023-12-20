package com.devjeong.watermelon_player.audioplayer

import kotlin.properties.Delegates

class PlayerState {
    var isPlaying: Boolean by Delegates.observable(false) { property, old, newValue ->
        // Do something when isPlaying changes
    }

    var isBuffering: Boolean by Delegates.observable(false) { property, old, newValue ->
        // Do something when isBuffering changes
    }

    var currentTime: Long by Delegates.observable(0L) { property, old, newValue ->
        // Do something when currentTime changes
    }

    var duration: Long = 0L

    var currentItemIndex: Int = -1

    var canNext: Boolean by Delegates.observable(false) { property, old, newValue ->
        // Do something when canNext changes
    }

    var canPrev: Boolean by Delegates.observable(false) { property, old, newValue ->
        // Do something when canPrev changes
    }
}

fun rememberPlayerState(): PlayerState {
    return PlayerState()
}