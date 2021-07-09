package com.eozsahin.feeddemo.models

/**
 * Data class for comments.
 */
data class Comment(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)
