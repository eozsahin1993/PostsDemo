package com.eozsahin.feeddemo.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.eozsahin.feeddemo.ui.components.Drawer
import com.eozsahin.feeddemo.ui.components.FAB
import com.eozsahin.feeddemo.ui.components.TopBar
import com.eozsahin.feeddemo.ui.navigation.AppNavHost
import com.eozsahin.feeddemo.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                StatusBar()
                Main()
            }
        }
    }

    @Composable
    fun Main() {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { TopBar(navController, scaffoldState) },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { FAB(navController)},
            drawerContent = {
                Drawer {
                    Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
                }
            },
        ) {
            AppNavHost(navController)
        }
    }

    @Composable
    fun StatusBar() {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = MaterialTheme.colors.isLight
        SideEffect {
            // Update all of the system bar colors to be transparent, and use
            // dark icons if we're in light theme
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons
            )

            // setStatusBarsColor() and setNavigationBarsColor() also exist

        }
    }
}