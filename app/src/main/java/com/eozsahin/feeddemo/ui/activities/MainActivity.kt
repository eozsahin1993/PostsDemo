package com.eozsahin.feeddemo.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.eozsahin.feeddemo.ui.components.Drawer
import com.eozsahin.feeddemo.ui.components.FAB
import com.eozsahin.feeddemo.ui.components.TopBar
import com.eozsahin.feeddemo.ui.navigation.AppNavHost
import com.eozsahin.feeddemo.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
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
}