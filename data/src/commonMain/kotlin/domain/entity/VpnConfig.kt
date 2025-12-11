package domain.entity

import io.ktor.http.HttpMessage
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import okio.ByteString.Companion.decodeBase64

@Serializable
data class VpnConfigDTO(
    val signBoxConfig: SingBoxConfig? = null,
    val message: String? = null
)
@Serializable
data class SingBoxConfig(
    val dns: Dns? = null,
    val log: Log? = null,
    val route: Route? = null,
    val inbounds: List<Inbound>? = null,
    val outbounds: List<Outbounds>? = null,
    val experimental: Experimental? = null
)

@Serializable
data class Dns(
    val rules: List<Rule>? = null,
    val fakeip: FakeIp? = null,
    val servers: List<Server>? = null,
    val independent_cache: Boolean? = null
)

@Serializable
data class Rule(
    val server: String? = null,
    val query_type: List<String>? = null,
    val outbound: String? = null
)

@Serializable
data class FakeIp(
    val enabled: Boolean? = null,
    val inet4_range: String? = null,
    val inet6_range: String? = null,
)

@Serializable
data class Server(
    val tag: String? = null,
    val detour: String? = null,
    val address: String? = null,
    val strategy: String? = null,
    val address_strategy: String? = null,
)

@Serializable
data class Log(
    val level: String? = null,
    val disabled: Boolean? = null,
    val timestamp: Boolean? = null,
)

@Serializable
data class Route(
    val rules: List<RuleOfRoute>? = null,
    val override_android_vpn: Boolean? = null,
    val auto_detect_interface: Boolean? = null,
)

@Serializable
data class RuleOfRoute(
    val action: String? = null,
    val mode: String? = null,
    val type: String? = null,
    val rules: List<RulesOfRules>? = null,
    val outbound: String? = null,
    val ip_is_private: Boolean? = null,
)

@Serializable
data class RulesOfRules(
    val protocol: String? = null,
    val port: Int? = null,
)

@Serializable
data class Inbound(
    val mtu: Int? = null,
    val tag: String? = null,
    val type: String? = null,
    val sniff: Boolean? = null,
    val stack: String? = null,
    val platform: Platform? = null,
    val auto_route: Boolean? = null,
    val strict_route: Boolean? = null,
    val inet4_address: String? = null,
    val inet6_address: String? = null,
    val interface_name: String? = null,
    val endpoint_independent_nat: Boolean? = null,
    val users: List<UserBox>? = null, // под вопросом
    val listen: String? = null,
    val listen_port: Int? = null,
    val set_system_proxy: Boolean? = null
)

@Serializable
data class UserBox(
    val hz: String? = null
)
@Serializable
data class Platform(
    val http_proxy: HttpProxy? = null
)

@Serializable
data class HttpProxy(
    val server: String? = null,
    val enabled: Boolean? = null,
    val server_port: Int? = null,
)

@Serializable
data class Outbounds(
    val tag: String? = null,
    val type: String? = null,
    val outbounds: List<String>? = null,
    val interrupt_exist_connections: Boolean? = null,
    val server: String? = null,
    val server_port: Int? = null,
    val flow: String? = null,
    val tls: Tls? = null,
    val uuid: String? = null,
    val transport: Transport? = null
)

@Serializable
data class Tls(
    val enabled: Boolean? = null,
    val server_name: String? = null,
    val reality: Reality? = null,
    val utls: Utls? = null
)

@Serializable
data class Reality(
    val enabled: Boolean? = null,
    val public_key: String? = null,
    val short_id: String? = null,
)

@Serializable
data class Utls(
    val enabled: Boolean? = null,
    val fingerprint: String? = null,
)

@Serializable
data class Transport(
    val headers: HeadersTransport? = null, // под вопросом
    val path: String? = null,
    val type: String? = null,
)

@Serializable
data class HeadersTransport(
    val values: Map<String, String>? = null
)

@Serializable
data class Experimental(
    val clash_api: ClashApi? = null,
    val cache_file: CacheFile? = null,
)

@Serializable
data class ClashApi(
    val external_ui: String? = null,
    val default_mode: String? = null,
    val external_controller: String? = null,
    val external_ui_download_url: String? = null,
    val external_ui_download_detour: String? = null,
)

@Serializable
data class CacheFile(
    val path: String? = null,
    val enabled: Boolean? = null,
    val cache_id: String? = null,
    val store_fakeip: Boolean? = null,
)

fun base64Decode(base64: String): String {
    // Используем okio, работает на всех платформах
    return base64.decodeBase64()?.utf8() ?: throw IllegalArgumentException("Invalid Base64")
}

//// Base64 -> VpnConfig
//fun base64ToVpnConfig(base64: String): List<VpnConfig> {
//    val jsonString = base64Decode(base64)
//    return Json { ignoreUnknownKeys = true }.decodeFromString(jsonString)
//}