package com.eozsahin.feeddemo.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data model for posts.
 */
@Serializable
data class Post(
    @SerialName("id") val id: Int,
    @SerialName("userId") val userId: Int,
    @SerialName("title") val title: String,
    @SerialName("body") val body: String,
)
