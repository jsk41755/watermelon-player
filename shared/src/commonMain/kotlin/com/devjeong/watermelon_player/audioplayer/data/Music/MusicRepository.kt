package com.devjeong.watermelon_player.audioplayer.data.Music

import com.devjeong.watermelon_player.NetworkConstants
import com.devjeong.watermelon_player.audioplayer.domain.music.MusicClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

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

