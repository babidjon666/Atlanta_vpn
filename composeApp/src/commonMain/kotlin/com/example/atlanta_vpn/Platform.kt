package com.example.atlanta_vpn

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform