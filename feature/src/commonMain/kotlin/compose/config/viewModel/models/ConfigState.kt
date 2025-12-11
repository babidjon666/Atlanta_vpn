package compose.config.viewModel.models

import domain.entity.SingBoxConfig
import domain.entity.SubResponse

data class ConfigState(
    val configUrl: String = "",
    val subResponse: SubResponse? = null,
    val signBoxConfig: SingBoxConfig? = null,
    val message: String? = null
)