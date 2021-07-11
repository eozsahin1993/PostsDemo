package com.eozsahin.feeddemo.ui.models

data class Post(
    var id: Int,
    val title: String,
    val body: String,
    val likes: Int,
    val comments: Int,
    val userName: String,
    val userImgUrl: String,
)