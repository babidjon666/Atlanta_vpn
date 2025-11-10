package compose.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import compose.DefaultAtlantaBackGround
import compose.auth.viewModel.models.AuthEvent
import compose.auth.viewModel.models.AuthState
import kotlinx.coroutines.delay
import utils.LottieAnimation

@Composable
fun AuthView(state: AuthState, eventHandler: (AuthEvent) -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        eventHandler.invoke(AuthEvent.ClickOpenMainScreen)
    }

    DefaultAtlantaBackGround {
        if (state.showStartAnimation) {
            LottieAnimation(
                jsonPath = "files/startAuth_Animation.json",
                isLoop = true
            )
        }
    }
}