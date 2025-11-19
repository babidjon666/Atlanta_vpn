package navigation


import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import compose.auth.AuthScreen
import compose.main.MainScreen
import compose.settings.SettingsScreen

@Composable
fun GenerateMainGraph(navController: NavHostController) {
    CompositionLocalProvider(LocalMainNavHost provides navController) {
        NavHost(
            navController = navController,
            startDestination = Routes.AUTH,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable(
                route = Routes.AUTH
            ) {
                AuthScreen()
            }

            composable(
                route = Routes.MAIN
            ) {
                MainScreen()
            }

            composable(
                route = Routes.SETTINGS
            ) {
                SettingsScreen()
            }
        }
    }
}