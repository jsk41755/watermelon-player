package com.devjeong.watermelon_player.android.extensions

import androidx.media3.common.MediaItem
import com.devjeong.watermelon_player.models.Music

fun List<Music>.toMediaItemList(): MutableList<MediaItem> {
    return this.map { MediaItem.fromUri(it.streamUrl) }.toMutableList()
}

fun Long.convertToText(): String {
    val sec = this / 1000
    val minutes = sec / 60
    val seconds = sec % 60

    val minutesString = if (minutes < 10) {
        "0$minutes"
    } else {
        minutes.toString()
    }
    val secondsString = if (seconds < 10) {
        "0$seconds"
    } else {
        seconds.toString()
    }
    return "$minutesString:$secondsString"
}
