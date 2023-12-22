package com.devjeong.watermelon_player.audioplayer.data.Music

import NetworkConstants
import com.devjeong.watermelon_player.audioplayer.domain.music.MusicClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class MusicRepository : MusicClient {
    override suspend fun getMusicList(): List<MusicDto> {
        return KtorMusicClient.httpClient.get(NetworkConstants.supabase.supabaseUrl) {
            url {
                parameters.append("select", "*")
            }
            contentType(ContentType.Application.Json)
        }.body<List<MusicDto>>()
    }
}

