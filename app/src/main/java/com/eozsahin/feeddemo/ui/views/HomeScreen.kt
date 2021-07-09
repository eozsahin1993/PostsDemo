package com.eozsahin.feeddemo.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun getHeader() {
    Card {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                Modifier.fillMaxHeight(),
            ) {
                Text("Name", style = MaterialTheme.typography.h6)
                Text("Name", style = MaterialTheme.typography.body1)
            }
        }
    }
}


