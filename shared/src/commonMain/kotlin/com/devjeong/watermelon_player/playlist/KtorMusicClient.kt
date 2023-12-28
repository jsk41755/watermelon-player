package com.devjeong.watermelon_player.playlist

import io.ktor.client.*
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorMusicClient {

    private val json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(json)
        }

        install(Logging){
            logger = object : Logger{
                override fun log(message: String) {
                    println("api log: $message")
                }
            }
            level = LogLevel.ALL
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15_000
            connectTimeoutMillis = 15_000
            socketTimeoutMillis = 15_000
        }

        defaultRequest {
            headers.append("Accept", "application/json")
            headers.append("Content-Type", "application/json")
            headers.append("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InB4aXJzdWpzdXlycWhtd2JlZ3J4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDMwNTc4NzgsImV4cCI6MjAxODYzMzg3OH0.IFf8tIJkqW-ruZz9nXG-D2kp3Hm6kmZipP--cQWDm00")
        }

    }
}