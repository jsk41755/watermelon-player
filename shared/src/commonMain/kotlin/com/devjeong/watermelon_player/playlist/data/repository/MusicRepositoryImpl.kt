package com.devjeong.watermelon_player.playlist.data.repository

import com.devjeong.watermelon_player.playlist.model.Music
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json

class MusicRepositoryImpl(private val httpClient: HttpClient) : MusicRepository {
    override suspend fun fetchMusicList(): List<Music> {
        val getUrl = "https://pxirsujsuyrqhmwbegrx.supabase.co/rest/v1/Music"

        val response: HttpResponse =
            httpClient.get(getUrl) {
                url {
                    parameters.append("select", "*")
                }
            }



        if (response.status.isSuccess()) {
            val responseBody: String = response.body()
            println(response)
            return Json.decodeFromString<List<Music>>(responseBody)
        } else {
            println(response)
            throw Exception("Failed to fetch music list: ${response.status.description}")
        }
    }
}

