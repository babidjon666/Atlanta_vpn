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
            Text(
                text = "С возвращением!",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(700, delayMillis = 300))
        ) {
            Text(text = "Вы ещё не подключились к Atlanta VPN.", fontSize = 15.sp)
        }

        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(700, delayMillis = 450))
        ) {
            Text(text = "Чтобы подключиться, следуйте", fontSize = 15.sp)
        }

        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(700, delayMillis = 600))
        ) {
            Text(text = "инструкции ниже.", fontSize = 15.sp)
        }
    }
}