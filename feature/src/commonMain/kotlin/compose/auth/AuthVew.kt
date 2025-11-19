package compose.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import compose.auth.viewModel.models.AuthEvent
import compose.auth.viewModel.models.AuthState

@Composable
fun AuthView(state: AuthState, eventHandler: (AuthEvent) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Column{
            Text("Тут типа жеская анимация")
        }
    }
}