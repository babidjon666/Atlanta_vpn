package com.example.atlanta_vpn

import androidx.compose.runtime.*
import compose.auth.AuthScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import domain.entity.User

@Composable
@Preview
fun App() {
    val user = User(name = "Atlanta")

    AuthScreen()
}