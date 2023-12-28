package com.devjeong.watermelon_player.playlist.data.repository

import com.devjeong.watermelon_player.NetworkConstants
import com.devjeong.watermelon_player.playlist.model.Music
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json

class MusicRepositoryImpl(private val httpClient: HttpClient) : MusicRepository {
    override suspend fun fetchMusicList(): List<Music> {
        val response: HttpResponse = httpClient.get("${NetworkConstants.supabase.supabaseUrl}?select=*") {
            headers.append("apikey", NetworkConstants.supabase.supabaseKey)
        }

        if (response.status.isSuccess()) {
            val responseBody: String = response.body()
            return Json.decodeFromString<List<Music>>(responseBody)
        } else {
            throw Exception("Failed to fetch music list: ${response.status.description}")
        }
    }
}

