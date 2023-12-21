package com.devjeong.watermelon_player.audioplayer.data.remote

import io.ktor.client.HttpClient

expect class HttpClientFactory {
    fun create(): HttpClient
}