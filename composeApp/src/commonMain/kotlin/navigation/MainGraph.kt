package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.auth.AuthScreen
import compose.main.MainScreen

@Composable
fun GenerateMainGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainScreens.AuthScreen) {
        composable<MainScreens.AuthScreen> { AuthScreen() }
        composable<MainScreens.MainScreen> { MainScreen() }
    }
}