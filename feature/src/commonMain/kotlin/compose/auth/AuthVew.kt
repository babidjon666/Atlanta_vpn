package compose.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF001F54),
                        Color(0xFF005C97),
                        Color(0xFF00C6FF)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.25f),
                        Color.Transparent
                    ),
                    center = center,
                    radius = size.minDimension / 1.5f
                ),
                center = center,
                radius = size.minDimension / 1.5f
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.showStartAnimation) {
                LottieAnimation(
                    jsonPath = "files/startAuth_Animation.json",
                    isLoop = true
                )
            }
        }
    }
}