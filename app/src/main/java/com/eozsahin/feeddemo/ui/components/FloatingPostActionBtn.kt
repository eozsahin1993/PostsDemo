package com.eozsahin.feeddemo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Preview
@Composable
fun getFAB() {
    FloatingActionButton(onClick = { } ) {
        Icon(Icons.Filled.Create, contentDescription = "post")
    }
}

class FABParameterProvider : PreviewParameterProvider<() -> Unit> {
    override val values: Sequence<() -> Unit> = sequence {  }
}