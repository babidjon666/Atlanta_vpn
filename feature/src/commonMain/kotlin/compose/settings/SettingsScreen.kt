package compose.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import compose.settings.viewModel.SettingsViewModel
import navigation.LocalMainNavHost

@Composable
fun SettingsScreen(){
    val mainNavHost = LocalMainNavHost.current

    val viewModel: SettingsViewModel = viewModel { SettingsViewModel() }
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    SettingsView(viewState) { event ->
        viewModel.obtainEvent(event)
    }

    when(viewAction){

        else -> {

        }
    }
}