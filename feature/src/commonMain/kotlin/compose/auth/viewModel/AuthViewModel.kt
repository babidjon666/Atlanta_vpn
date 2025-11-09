package compose.auth.viewModel

import base.BaseViewModel
import compose.auth.viewModel.models.AuthAction
import compose.auth.viewModel.models.AuthEvent
import compose.auth.viewModel.models.AuthState

class AuthViewModel: BaseViewModel<AuthState, AuthAction, AuthEvent>(
    initialState = AuthState()
) {
    override fun obtainEvent(viewEvent: AuthEvent) {
        when(viewEvent){

            else -> {}
        }
    }
}