package compose.main.viewModel.models

sealed class MainEvent {
    data object ConnectVpn: MainEvent()
    data object DisconnectVpn: MainEvent()
}