package com.devjeong.watermelon_player

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform