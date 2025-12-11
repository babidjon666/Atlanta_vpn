package compose.config.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.AcceptButton
import compose.ConfigTextField
import compose.config.viewModel.models.ConfigEvent
import compose.config.viewModel.models.ConfigState
import ui.AtlantaColors
import utils.AtlantaText

@Composable
fun PasteUrlView(state: ConfigState, evenHandler: (ConfigEvent) -> Unit){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AtlantaText(
            text = "Добавьте ключи",
            weight = 700f,
            size = 35f,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(25.dp))
        AtlantaText(
            text = "К сожалению, у вас нету активных",
            weight = 400f,
            size = 15f,
            color = Color.Black
        )
        AtlantaText(
            text = "ключей. Пожалуйста, введите",
            weight = 400f,
            size = 15f,
            color = Color.Black
        )
        AtlantaText(
            text = "действующий ключ.",
            weight = 400f,
            size = 15f,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(40.dp))
        ConfigTextField(
            configUrl = state.configUrl
        ){
            evenHandler.invoke(ConfigEvent.UpdateConfigUrlField(it))
        }
        Spacer(modifier = Modifier.height(15.dp))
        AcceptButton{
            evenHandler.invoke(ConfigEvent.ClickEnterUrl(state.configUrl))
            println("COINFIG ${state.configUrl}")
        }
    }
}