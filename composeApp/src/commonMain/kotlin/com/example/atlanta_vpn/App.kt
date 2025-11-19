package com.example.atlanta_vpn

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import compose.LiquidGlassBottomBar
import compose.models.AppTabItem
import navigation.GenerateMainGraph
import navigation.Routes


@Composable
fun App() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val tabs = remember {
        listOf(
            AppTabItem("Мои ключи", "tray.full", "tray.full", Routes.AUTH),
            AppTabItem("Главная", "shield.lefthalf.filled", "shield.lefthalf.filled", Routes.MAIN),
            AppTabItem("Настройки", "gear", "gear", Routes.SETTINGS)
        )
    }

    val selectedIndex = remember(currentRoute) {
        tabs.indexOfFirst { it.route == currentRoute }
            .coerceIn(0, tabs.lastIndex)
    }

    val bottomBarComposable = remember {
        mutableStateOf<(@Composable (Int) -> Unit)?>(null)
    }

    LaunchedEffect(Unit) {
        bottomBarComposable.value = { selected ->
            LiquidGlassBottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                tabs = tabs,
                selectedIndex = selected,
                onSelect = { index ->
                    val route = tabs[index].route
                    navController.navigate(route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            GenerateMainGraph(navController)
        }

        if (currentRoute != Routes.AUTH) {
            bottomBarComposable.value?.invoke(selectedIndex)
        }
    }
}