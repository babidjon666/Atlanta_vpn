package domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class SubResponse(
    val response: ResponseData? = null,
    val path: String? = null,
    val message: String? = null,
    val errorCode: String? = null,
)
@Serializable
data class ResponseData(
    val isFound: Boolean? = null,
    val user: UserData? = null,
    val subscriptionUrl: String? = null,
    val happ: HappData? = null
)
@Serializable
data class UserData(
    val shortUuid: String? = null,
    val daysLeft: Int? = null,
    val trafficUsed: String? = null,
    val trafficLimit: String? = null,
    val lifetimeTrafficUsed: String? = null,
    val lifetimeTrafficUsedBytes: String? = null,
    val trafficLimitBytes: String? = null,
    val trafficUsedBytes: String? = null,
    val username: String? = null,
    val expiresAt: String? = null,
    val isActive: Boolean? = null,
    val userStatus: String? = null,
    val trafficLimitStrategy: String? = null
)
@Serializable
data class HappData(
    val cryptoLink: String? = null
)