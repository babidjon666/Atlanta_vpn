package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import compose.auth.AuthScreen
import compose.main.MainScreen

@Composable
fun GenerateMainGraph(navController: NavHostController) {

    CompositionLocalProvider(LocalMainNavHost provides navController) {
        NavHost(
            navController = navController,
            startDestination = MainScreens.AuthScreen
        ) {
            composable<MainScreens.AuthScreen> { AuthScreen() }
            composable<MainScreens.MainScreen> { MainScreen() }
        }
    }
}