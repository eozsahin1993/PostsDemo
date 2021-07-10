package com.eozsahin.feeddemo.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.models.Post
import com.eozsahin.feeddemo.repos.getPostRepository
import com.eozsahin.feeddemo.ui.components.getFAB
import com.eozsahin.feeddemo.ui.components.getPostCard
import com.eozsahin.feeddemo.ui.components.getTopBar
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
                        Text(text = "drawerContent")
                    }},
                    content = {
                        homeScreen(model = viewModel)
                    }
                )


            }
        }
    }


}