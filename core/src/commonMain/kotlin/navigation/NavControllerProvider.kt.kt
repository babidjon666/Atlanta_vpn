package navigation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController


val LocalMainNavHost = staticCompositionLocalOf<NavHostController> {
    error("NavController not provided")
}