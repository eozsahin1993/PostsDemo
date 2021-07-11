package com.eozsahin.feeddemo.ui.models

data class Comment(
    val id: Int,
    val userName: String,
    val userImgUrl: String,
    var body: String,
)