package com.eozsahin.feeddemo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data model for Users.
 */
@Serializable
data class UserData(
    @SerialName("id") val id: Int = 0,
    @SerialName("name") val name: String = "",
    @SerialName("username") val userName: String = "",
    @SerialName("email") val email: String = "",
    @SerialName("phone") val phone: String = ""
)
