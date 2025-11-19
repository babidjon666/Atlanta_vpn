package compose.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import compose.settings.viewModel.models.SettingsEvent
import compose.settings.viewModel.models.SettingsState

@Composable
fun SettingsView(state: SettingsState, eventHandler: (SettingsEvent) -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Text("SETTINGS")
    }
}