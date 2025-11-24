package compose.main.viewModel

import base.BaseViewModel
import compose.main.viewModel.models.MainAction
import compose.main.viewModel.models.MainEvent
import compose.main.viewModel.models.MainState
import compose.models.AppTabItem

class MainViewModel: BaseViewModel<MainState, MainAction, MainEvent>(
    initialState = MainState()
) {
    override fun obtainEvent(viewEvent: MainEvent) {
        when(viewEvent){
            is MainEvent.ConnectVpn -> connectVpn()
            is MainEvent.DisconnectVpn -> disconnectVpn()
        }
    }

    private fun connectVpn(){
        viewState = viewState.copy(
            isVpnConnected = true
        )
    }

    private fun disconnectVpn(){
        viewState = viewState.copy(
            isVpnConnected = false
        )
    }
}