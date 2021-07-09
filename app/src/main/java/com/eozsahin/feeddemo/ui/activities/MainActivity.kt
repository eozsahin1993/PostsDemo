package com.eozsahin.feeddemo.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.ui.components.getPostCard
import com.eozsahin.feeddemo.ui.theme.AppTheme
import com.eozsahin.feeddemo.ui.views.getHeader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Column(modifier = Modifier.padding(10.dp)) {
                    getPostCard()
                    Spacer(Modifier.size(10.dp))
                    getPostCard()
                    Spacer(Modifier.size(10.dp))
                    getPostCard()
                    Spacer(Modifier.size(10.dp))
                    getPostCard()
                    Spacer(Modifier.size(10.dp))
                    getPostCard()
                    Spacer(Modifier.size(10.dp))

                }

            }
        }
    }
}