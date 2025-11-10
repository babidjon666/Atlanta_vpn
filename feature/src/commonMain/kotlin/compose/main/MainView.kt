package compose.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import compose.main.viewModel.models.MainEvent
import compose.main.viewModel.models.MainState

@Composable
fun MainView(state: MainState, evenHandler: (MainEvent) -> Unit){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = state.test)
    }
}