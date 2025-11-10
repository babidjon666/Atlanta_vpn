package compose.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import compose.main.viewModel.MainViewModel
import navigation.LocalMainNavHost

@Composable
fun MainScreen(){
    val mainNavHost = LocalMainNavHost.current

    val viewModel: MainViewModel = viewModel { MainViewModel() }
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    MainView(viewState) { event ->
        viewModel.obtainEvent(event)
    }

    when(viewAction){
        null -> {
        }
    }
}