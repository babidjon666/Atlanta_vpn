package navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
            composable<MainScreens.AuthScreen>(
                enterTransition = {
                    fadeIn(animationSpec = tween(700)) + scaleIn(
                        initialScale = 0.95f,
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    fadeOut(animationSpec = tween(600)) + scaleOut(
                        targetScale = 1.05f,
                        animationSpec = tween(600)
                    )
                },
                popEnterTransition = {
                    fadeIn(animationSpec = tween(500))
                },
                popExitTransition = {
                    fadeOut(animationSpec = tween(500))
                }
            ) { AuthScreen() }

            composable<MainScreens.MainScreen>(
                enterTransition = {
                    fadeIn(animationSpec = tween(800)) + scaleIn(
                        initialScale = 1.1f,
                        animationSpec = tween(800)
                    )
                },
                exitTransition = {
                    fadeOut(animationSpec = tween(400))
                },
                popEnterTransition = {
                    fadeIn(animationSpec = tween(500)) + scaleIn(
                        initialScale = 0.9f,
                        animationSpec = tween(500)
                    )
                },
                popExitTransition = {
                    fadeOut(animationSpec = tween(400))
                }
            ) { MainScreen() }
        }
    }
}