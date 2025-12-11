package compose.config

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.AcceptButton
import compose.ConfigTextField
import compose.config.viewModel.models.ConfigEvent
import compose.config.viewModel.models.ConfigState
import compose.config.views.ConfigListView
import compose.config.views.PasteUrlView
import ui.AtlantaColors
import utils.AtlantaText

@Composable
fun ConfigView(state: ConfigState, evenHandler: (ConfigEvent) -> Unit){
    if (state.subResponse != null){
        ConfigListView(state, evenHandler)
    }else{
        PasteUrlView(state, evenHandler)
    }
}