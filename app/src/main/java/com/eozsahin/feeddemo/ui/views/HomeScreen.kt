package com.eozsahin.feeddemo.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

class HomeScreen {

    @Preview(showBackground = true)
    @Composable
    fun getScreen() {
        Box {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text("Name", fontWeight = FontWeight.Bold)
                    Text("Name", style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}