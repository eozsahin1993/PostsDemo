package com.eozsahin.feeddemo.ui.components

import android.util.Log
import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Task
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.R
import com.eozsahin.feeddemo.ui.theme.AppTheme
import com.eozsahin.feeddemo.ui.theme.AppTypography
import com.google.android.material.chip.Chip

@Preview()
@Composable
fun getPostCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            getPostCardHeader()
            getPostCardContent()
            getPostCardFooter()
        }
    }
}

@Composable
fun getPostCardHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "UserImage",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(5.dp)) {
            Text("Alfred Sisley",
                style = AppTypography.body2,

            )
            Text("x seconds ago",
                style = AppTypography.caption,
                color = Color.Gray)
        }
    }
}

@Composable
fun getPostCardContent() {
    Column() {
        Text(
            "Krea molestias quasi exercitationem repellat qui ipsa sit aut",
            style = AppTypography.subtitle1,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            "t iusto sed quo iurenvoluptatem occaecati omnis eligendi aut adnvoluptatem doloribus vel accusantium quis pariaturnmolestiae porro eius odio et labore et velit aut",
            modifier = Modifier.padding(start = 12.dp, end = 10.dp, bottom = 10.dp),
            style = AppTypography.caption
        )
    }
}

@Composable
fun getPostCardFooter() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Filled.Favorite,
                "contentDescription",
                tint = Color.Magenta)
            Text("15 likes")

            Icon(
                Icons.Filled.QuestionAnswer,
                "contentDescription",
                tint = Color.Magenta)
            Text("13 comments")
        }

        Row(verticalAlignment =  Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
            Button(onClick = {
                Log.i("emre", "tapped")
            }, modifier = Modifier.clip(CircleShape)) {
                Text("Add comment", style = AppTypography.caption)
            }
        }
    }

//    val textState = remember { mutableStateOf(TextFieldValue()) }
//    OutlinedTextField(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(15.dp),
//        placeholder = { Text("Add comment...")} ,
//        value = textState.value,
//        onValueChange = { textState.value = it }
//    )
}


