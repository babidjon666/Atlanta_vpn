package compose.config.viewModel.models

sealed class ConfigEvent {
    data class UpdateConfigUrlField(val newUrl: String): ConfigEvent()
    data class ClickEnterUrl(val url: String): ConfigEvent()
}