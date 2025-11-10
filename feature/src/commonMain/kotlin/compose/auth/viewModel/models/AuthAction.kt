package compose.auth.viewModel.models

sealed class AuthAction {
    data object OpenMainScreen: AuthAction()
}