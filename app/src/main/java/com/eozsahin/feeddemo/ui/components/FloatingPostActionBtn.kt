package com.eozsahin.feeddemo.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eozsahin.feeddemo.ui.navigation.Screen

@Composable
fun FAB(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.getFromNav(navBackStackEntry)

    if (currentScreen == Screen.Posts) {
        FloatingActionButton(
            onClick = {
                navController.navigate(Screen.CreatePost.route)
            }
        ) {
            Icon(Icons.Filled.Create, "")
        }
    }
}