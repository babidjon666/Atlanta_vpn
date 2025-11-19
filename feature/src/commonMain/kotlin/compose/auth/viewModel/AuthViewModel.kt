package compose.auth.viewModel

import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import compose.auth.viewModel.models.AuthAction
import compose.auth.viewModel.models.AuthEvent
import compose.auth.viewModel.models.AuthState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthViewModel: BaseViewModel<AuthState, AuthAction, AuthEvent>(
    initialState = AuthState()
) {
    init {
        viewModelScope.launch {
            delay(2000)
            viewAction = AuthAction.OpenMainScreen
        }
    }
    override fun obtainEvent(viewEvent: AuthEvent) {
        when(viewEvent){

            else -> {}
        }
    }


}