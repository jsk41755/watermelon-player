package com.devjeong.watermelon_player.models

import kotlinx.serialization.Serializable

@Serializable
data class Music(
    val id: Int,
    val title: String,
    val artists: String,
    val img_url: String,
    val stream_url: String,
    val duration: String,
    val created_at: String
)
