package com.eozsahin.feeddemo.ui.models

data class PostDetail (
    val id: Int = 0,
    val title: String = "",
    val body: String = "",
    val likes: Int = 0,
    val userName: String = "",
    val userImgUrl: String = "",
    val comments: List<Comment> = listOf()
) {
    fun toPost(): Post {
        return Post(
            id = id,
            title = title,
            body = body,
            comments = comments.size,
            userImgUrl = userImgUrl,
            likes = likes,
            userName = userName
        )
    }
}