package com.example.atlanta_vpn

import androidx.compose.ui.window.ComposeUIViewController
import domain.entity.Api.createHttpClient
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController {
    initAppDI(createHttpClient(Darwin.create()))
    App()
}