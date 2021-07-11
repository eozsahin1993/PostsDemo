package com.eozsahin.feeddemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eozsahin.feeddemo.ui.viewmodels.CreatePostViewModel
import com.eozsahin.feeddemo.ui.viewmodels.HomeViewModel
import com.eozsahin.feeddemo.ui.viewmodels.PostDetailsViewModel
import com.eozsahin.feeddemo.ui.views.CreatePostScreen
import com.eozsahin.feeddemo.ui.views.PostDetailsScreen
import com.eozsahin.feeddemo.ui.views.homeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Posts.route) {
        composable(Screen.Posts.route) {
            val homeViewModel = HomeViewModel()

            homeScreen(homeViewModel, navController = navController)
        }

        composable(Screen.PostDetails.route) {
            val id = it.arguments?.getString("id") ?: "1"
            val postDetailsViewModel = PostDetailsViewModel(id)

            PostDetailsScreen(postDetailsViewModel)
        }

        composable(Screen.CreatePost.route) {
            val viewModel = CreatePostViewModel()
            CreatePostScreen(viewModel, navController)
        }
    }
}
