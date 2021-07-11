package com.eozsahin.feeddemo.ui.navigation

import androidx.navigation.NavBackStackEntry
import com.eozsahin.feeddemo.ui.navigation.Routes.ROUTE_CREATE_POST
import com.eozsahin.feeddemo.ui.navigation.Routes.ROUTE_POSTS
import com.eozsahin.feeddemo.ui.navigation.Routes.ROUTE_POST_DETAILS

private object Routes {
    const val ROUTE_POSTS = "posts"
    const val ROUTE_POST_DETAILS = "posts/{id}"
    const val ROUTE_CREATE_POST = "createPost"
}

sealed class Screen(val route: String, val title: String) {
    object Posts: Screen(ROUTE_POSTS, "Posts")
    object PostDetails: Screen(ROUTE_POST_DETAILS, "Post Details")
    object CreatePost: Screen(ROUTE_CREATE_POST, "Create Post")

    companion object {
        fun getFromNav(navBackStackEntry: NavBackStackEntry?): Screen {
            return when (navBackStackEntry?.destination?.route ?: "") {
                ROUTE_POSTS -> Posts
                ROUTE_POST_DETAILS -> PostDetails
                ROUTE_CREATE_POST -> CreatePost
                else -> Posts
            }
        }
    }
}