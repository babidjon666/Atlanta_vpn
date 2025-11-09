package compose.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import compose.auth.viewModel.models.AuthEvent
import compose.auth.viewModel.models.AuthState
import utils.LottieAnimation

@Composable
fun AuthView(state: AuthState, eventHandler: (AuthEvent) -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            jsonPath = "files/startAuth_Animation.json",
            isLoop = true
        )
    }
}
