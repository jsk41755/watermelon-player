package com.devjeong.watermelon_player.data.repositories.music

import com.devjeong.watermelon_player.constants.NetworkConstants
import com.devjeong.watermelon_player.models.Music
import com.devjeong.watermelon_player.models.MusicEditRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json

class MusicRepositoryImpl(private val httpClient: HttpClient) : MusicRepository {
    override suspend fun fetchMusicList(): List<Music> {
        val response: HttpResponse = httpClient.get(NetworkConstants.BASE_URL) {
            url {
                parameters.append("select", "*")
            }
        }

        if (response.status.isSuccess()) {
            val responseBody: String = response.body()
            return Json.decodeFromString<List<Music>>(responseBody)
        } else {
            throw Exception("Failed to fetch music list: ${response.status.description}")
        }
    }

    override suspend fun fetchLikeMusicList(): List<Music> {
        val response: HttpResponse = httpClient.get(NetworkConstants.BASE_URL) {
            url {
                parameters.append("select", "*")
                parameters.append("like","eq.true")
            }
        }

        if (response.status.isSuccess()) {
            val responseBody: String = response.body()
            return Json.decodeFromString<List<Music>>(responseBody)
        } else {
            throw Exception("Failed to fetch music list: ${response.status.description}")
        }
    }

    override suspend fun toggleLike(id: Int, like: Boolean) {
        httpClient.patch(NetworkConstants.BASE_URL) {
            url {
                parameters.append("id", "eq.$id")
            }
            setBody(MusicEditRequest(like))
        }
    }
}

