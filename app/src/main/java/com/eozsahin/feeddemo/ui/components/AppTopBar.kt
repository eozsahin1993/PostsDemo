package com.eozsahin.feeddemo.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eozsahin.feeddemo.ui.navigation.Screen
import kotlinx.coroutines.launch


@Composable
fun TopBar(navController: NavController, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val title = Screen.getFromNav(navBackStackEntry).title

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        val state = scaffoldState.drawerState
                        if (state.isClosed) state.open() else state.close()
                    }
                }
            ) {
                Icon(Icons.Filled.Menu,"")
            }
        }
    )
}