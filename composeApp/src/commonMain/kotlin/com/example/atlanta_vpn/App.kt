package com.example.atlanta_vpn

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import navigation.GenerateMainGraph

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    GenerateMainGraph(navController = navController)
}