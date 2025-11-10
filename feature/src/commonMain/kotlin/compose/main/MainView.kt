package compose.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import compose.DefaultAtlantaBackGround
import compose.main.viewModel.models.MainEvent
import compose.main.viewModel.models.MainState

@Composable
fun MainView(state: MainState, evenHandler: (MainEvent) -> Unit) {
    DefaultAtlantaBackGround {
        Text(
            text = state.test,
            color = Color.White
        )
    }
}