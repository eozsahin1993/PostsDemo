package com.eozsahin.feeddemo.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.eozsahin.feeddemo.ui.components.getDrawer
import com.eozsahin.feeddemo.ui.components.getFAB
import com.eozsahin.feeddemo.ui.components.getTopBar
import com.eozsahin.feeddemo.ui.models.User
import com.eozsahin.feeddemo.ui.theme.AppTheme
import com.eozsahin.feeddemo.ui.viewmodels.HomeViewModel
import com.eozsahin.feeddemo.ui.views.homeScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        getTopBar {
                            scope.launch {
                                val state = scaffoldState.drawerState
                                if (state.isClosed) state.open() else state.close()
                            }
                        }
                     },
                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = {
                        getFAB()
                    },
                    drawerContent = { Surface(color = Color.White) {
                        getDrawer(model = viewModel) {
                            Toast.makeText(this@MainActivity, it, Toast.LENGTH_LONG).show()
                        }
                    }},
                    content = {
                        homeScreen(model = viewModel)
                    }
                )


            }
        }
    }


}