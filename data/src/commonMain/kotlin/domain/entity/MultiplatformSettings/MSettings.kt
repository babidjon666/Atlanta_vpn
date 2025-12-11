package domain.entity.MultiplatformSettings


import com.russhwolf.settings.Settings

import kotlinx.serialization.json.Json

//class MSettings(private val settings: Settings) {
//    fun save(config: VpnConfig) {
//        val json = Json.encodeToString(config)
//        settings.putString(
//            key = "vpn_config",
//            value = json
//        )
//    }
//
//    fun load(): VpnConfig? {
//        val json = settings.getStringOrNull("vpn_config") ?: return null
//        return Json.decodeFromString(json)
//    }
//
//    fun clear() {
//        settings.remove("vpn_config")
//    }
//}