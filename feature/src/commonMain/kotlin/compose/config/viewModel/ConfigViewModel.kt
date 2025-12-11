package compose.config.viewModel

import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import compose.config.viewModel.models.ConfigAction
import compose.config.viewModel.models.ConfigEvent
import compose.config.viewModel.models.ConfigState
import di.sharedDI
import domain.entity.Api.InsultCensorClient
import domain.entity.utills.NetworkError
import kotlinx.coroutines.launch
import org.kodein.di.direct
import org.kodein.di.instance
import domain.entity.utills.Result

class ConfigViewModel : BaseViewModel<ConfigState, ConfigAction, ConfigEvent>(
    initialState = ConfigState()
) {
    val api: InsultCensorClient = sharedDI.direct.instance()

    override fun obtainEvent(viewEvent: ConfigEvent) {
        when (viewEvent) {
            is ConfigEvent.UpdateConfigUrlField -> updateConfigUrlField(newConfigUrl = viewEvent.newUrl)
            is ConfigEvent.ClickEnterUrl -> enterUrl(viewEvent.url)
        }
    }

    private fun enterUrl(url: String) {
        if (url.isNotEmpty()) {
            viewModelScope.launch {
                val response = api.getUserSub(subscriptionUrl = url)
                val configResponse = api.getVpnConfig(subscriptionUrl = url)
                when (response) {
                    is Result.Success -> {
                        val subResponse = response.data
                        viewState = viewState.copy(
                            subResponse = subResponse
                        )
                        when (configResponse) {
                            is Result.Success -> {
                                configResponse.data.signBoxConfig?.let {
                                    viewState = viewState.copy(
                                        signBoxConfig = it,
                                        message = configResponse.data.message
                                    )
                                }
                            }

                            is Result.Error -> {
                                if (configResponse.error == NetworkError.TOO_MANY_DEVICES) {
                                    viewState = viewState.copy(
                                        message = "Вы достигли максимального количества устройств или не включен заголовок HWID"
                                    )
                                }
                            }
                        }
                    }

                    is Result.Error -> {
                        val error = response.error
                    }
                }
            }
        }
    }

    private fun updateConfigUrlField(newConfigUrl: String) {
        viewState = viewState.copy(
            configUrl = newConfigUrl
        )
    }
}