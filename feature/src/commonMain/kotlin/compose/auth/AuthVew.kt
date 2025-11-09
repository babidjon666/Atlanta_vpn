package compose.auth

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import compose.auth.viewModel.models.AuthEvent
import compose.auth.viewModel.models.AuthState

@Composable
fun AuthView(state: AuthState, eventHandler: (AuthEvent) -> Unit){
    Text(state.test)
}
