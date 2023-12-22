package com.devjeong.watermelon_player.audioplayer.data.Music

import kotlinx.serialization.Serializable

@Serializable
data class MusicDto(
    val streamUrl: String,
    val imageUrl: String,
    val artists: String,
    val title: String,
    val duration: String
)