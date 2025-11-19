package compose.settings.viewModel

import base.BaseViewModel
import compose.settings.viewModel.models.SettingsAction
import compose.settings.viewModel.models.SettingsEvent
import compose.settings.viewModel.models.SettingsState

class SettingsViewModel: BaseViewModel<SettingsState, SettingsAction, SettingsEvent>(
    initialState = SettingsState()
) {
    override fun obtainEvent(viewEvent: SettingsEvent) {
        when(viewEvent){

            else -> {}
        }
    }

}