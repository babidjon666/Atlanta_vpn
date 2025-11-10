package compose.auth.viewModel.models

sealed class AuthEvent {
    data object ClickOpenMainScreen: AuthEvent()
}