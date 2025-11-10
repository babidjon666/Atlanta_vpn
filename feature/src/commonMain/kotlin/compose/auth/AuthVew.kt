package compose.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.auth.viewModel.models.AuthEvent
import compose.auth.viewModel.models.AuthState
import kotlinx.coroutines.delay
import utils.LottieAnimation

@Composable
fun AuthView(state: AuthState, eventHandler: (AuthEvent) -> Unit){

    LaunchedEffect(Unit){
        delay(2000)
        eventHandler.invoke(AuthEvent.ClickOpenMainScreen)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.showStartAnimation){
            LottieAnimation(
                jsonPath = "files/startAuth_Animation.json",
                isLoop = true
            )
        }
    }
}
