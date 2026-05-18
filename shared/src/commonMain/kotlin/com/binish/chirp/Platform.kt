package com.binish.chirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform