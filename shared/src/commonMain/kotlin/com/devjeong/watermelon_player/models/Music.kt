package com.devjeong.watermelon_player.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Music(
    val id: Int,
    val title: String,
    val artists: String,
    @SerialName("img_url")
    val imgUrl: String,
    @SerialName("stream_url")
    val streamUrl: String,
    val duration: Int,
    @SerialName("created_at")
    val createdAt: String,
    val like: Boolean
)

@Serializable
data class MusicEditRequest (
    val like: Boolean
)