package com.eozsahin.feeddemo.ui.models

data class User(
    val id: Int,
    val name: String,
    val userName: String,
    val email: String,
    val profileImgUrl: String = ""
)