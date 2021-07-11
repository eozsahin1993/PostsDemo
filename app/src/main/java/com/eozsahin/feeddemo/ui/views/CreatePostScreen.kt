package com.eozsahin.feeddemo.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.viewmodels.CreatePostViewModel
import kotlinx.coroutines.launch

@Composable
fun CreatePostScreen(
    viewModel: CreatePostViewModel = CreatePostViewModel(),
    navCtrl: NavController
) {
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            placeholder = { Text("Post title...") },
            modifier = Modifier
                .fillMaxWidth(.9f)
                .defaultMinSize(minHeight = 50.dp),
            label = { Text("Title")}
        )
        OutlinedTextField(
            value = body,
            onValueChange = { body = it },
            placeholder = { Text("How is your day so far..") },
            modifier = Modifier
                .fillMaxWidth(.9f)
                .defaultMinSize(minHeight = 200.dp),
            label = { Text("Body") }
        )
        Button(
            onClick = {
                val post = Post(title = title, body = body)
                coroutineScope.launch {
                    viewModel.submitPost(1, post)
                    navCtrl.popBackStack()
                }
            }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Submit")
            }
        }
    }
}
