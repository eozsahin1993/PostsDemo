package com.eozsahin.feeddemo.ui.models

data class Post(
    var id: Int = 0,
    val title: String = "",
    val body: String = "",
    val likes: Int = 0,
    val comments: Int = 0,
    val userName: String = "",
    val userImgUrl: String = "",
)