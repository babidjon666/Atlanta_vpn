package compose.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel


import compose.auth.viewModel.AuthViewModel

@Composable
fun AuthScreen(){
    val viewModel: AuthViewModel = viewModel { AuthViewModel() }
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    AuthView(viewState) { event ->
        viewModel.obtainEvent(event)
    }

    when(viewAction){
        null -> {

        }
    }
}