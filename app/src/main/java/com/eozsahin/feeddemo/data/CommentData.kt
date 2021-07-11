package com.eozsahin.feeddemo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class for comments.
 */
@Serializable
data class CommentData(
    @SerialName("id") val id: Int,
    @SerialName("postId") val postId: Int,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("body") val body: String
)
