package domain.entity.Api

import domain.entity.SingBoxConfig
import domain.entity.SubResponse
import domain.entity.VpnConfigDTO
import domain.entity.base64Decode
import domain.entity.utills.NetworkError
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import domain.entity.utills.Result
import io.ktor.client.call.body
import io.ktor.client.request.headers
import utills.getHWID

class InsultCensorClient(
    private val httpClient: HttpClient
) {
    suspend fun getUserSub(subscriptionUrl: String): Result<SubResponse, NetworkError> {
        val code = subscriptionUrl.substringAfterLast("/")
        val response = try {
            httpClient.get(
                urlString = "https://panel.atlanta-vpn.com/api/sub/$code/info"
            )
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val sub = response.body<SubResponse>()
                Result.Success(sub)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    suspend fun getVpnConfig(subscriptionUrl: String): Result<VpnConfigDTO, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = subscriptionUrl
            ) {
                headers {
                    append("accept", "*/*")
                    append("user-agent", "Atlanta")
                    append(
                        "baggage",
                        "sentry-environment=production,sentry-public_key=7263b743b6f9ea1eb77478f5102e38b4,sentry-release=su.ffg.happ%403.5.2%2B2,sentry-trace_id=8bdd094bbf4847a5976fc32ee2e2b4a8"
                    )
                    append("x-hwid", getHWID()) // для теста - da8797650045324f da8797650045324d
                    append("priority", "u=3")
                }
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val announceHeader = response.headers["announce"]?.removePrefix("base64:")

                if (announceHeader != null){
                    val message = try{
                        base64Decode(announceHeader)
                    }catch (ex: SerializationException){
                        return Result.Error(NetworkError.SERIALIZATION)
                    }
                    if (message == "Вы достигли максимального количества устройств или не включен заголовок HWID"){
                        return Result.Error(NetworkError.TOO_MANY_DEVICES)
                    }else{
                        val config = response.body<SingBoxConfig>()

                        val result = VpnConfigDTO(
                            signBoxConfig = config,
                            message = message
                        )
                        return Result.Success(result)
                    }
                }else{
                    val config = response.body<SingBoxConfig>()
                    val result = VpnConfigDTO(
                        signBoxConfig = config,
                        message = null
                    )
                    return Result.Success(result)
                }
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}