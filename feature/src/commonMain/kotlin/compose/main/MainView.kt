package compose.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.RegionInfo
import compose.Timer
import compose.main.viewModel.models.MainEvent
import compose.main.viewModel.models.MainState
import utils.AnimatedTextBlock
import compose.Swipe

@Composable
fun MainView(state: MainState, evenHandler: (MainEvent) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedTextBlock()
        Spacer(modifier = Modifier.height(40.dp))
        Timer()
        Spacer(modifier = Modifier.height(9.dp))
        RegionInfo(regionName = "Россия")
        Spacer(modifier = Modifier.height(97.dp))
        BoxWithConstraints {
            val parentWidth = maxWidth

            Swipe(
                width = parentWidth,
                onSwipe = { evenHandler.invoke(MainEvent.ConnectVpn) },
                onClick = { evenHandler.invoke(MainEvent.DisconnectVpn) },
                isSwiped = state.isVpnConnected,
            )
        }
    }
}