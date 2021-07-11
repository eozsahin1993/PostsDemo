package com.eozsahin.feeddemo.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun getTopBar( onClick: () -> Unit = { }) {
    TopAppBar(title = { Text("Posts")

    }, navigationIcon = {
        IconButton(onClick = onClick) {
            Icon(Icons.Filled.Menu,"")
        }
    })
}