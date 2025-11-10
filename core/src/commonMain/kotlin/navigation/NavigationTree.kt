package navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class MainScreens {
    @Serializable
    data object AuthScreen: MainScreens()

    @Serializable
    data object MainScreen: MainScreens()
}