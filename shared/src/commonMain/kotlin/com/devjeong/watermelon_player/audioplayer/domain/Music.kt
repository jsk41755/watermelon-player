package com.devjeong.watermelon_player.audioplayer.domain

import kotlinx.serialization.Serializable

@Serializable
data class Music(
    val streamUrl: String,
    val imageUrl: String,
    val artists: String,
    val title: String,
    val duration: String
)