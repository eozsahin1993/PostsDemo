package com.eozsahin.feeddemo.models

/**
 * Data model for posts.
 */
data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
)
