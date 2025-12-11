package compose.config

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import compose.config.viewModel.ConfigViewModel
import navigation.LocalMainNavHost

@Composable
fun ConfigScreen(){
    val mainNavHost = LocalMainNavHost.current

    val viewModel: ConfigViewModel = viewModel { ConfigViewModel() }
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    ConfigView(viewState) { event ->
        viewModel.obtainEvent(event)
    }

    when(viewAction){
        null -> {
        }
    }
}