package utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimatedTextBlock() {
    val visible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible.value = true
    }

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn() + slideInVertically(initialOffsetY = { -40 })
        ) {
            AtlantaText(
                text = "С возвращением!",
                weight = 510f,
                size = 35f
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(700, delayMillis = 300))
        ) {
            AtlantaText(
                text = "Вы ещё не подключились к Atlanta VPN.",
                weight = 400f,
                size = 15f
            )
        }

        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(700, delayMillis = 450))
        ) {
            AtlantaText(
                text = "Чтобы подключиться, следуйте",
                weight = 400f,
                size = 15f
            )
        }

        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(700, delayMillis = 600))
        ) {
            AtlantaText(
                text = "инструкции ниже.",
                weight = 400f,
                size = 15f
            )
        }
    }
}