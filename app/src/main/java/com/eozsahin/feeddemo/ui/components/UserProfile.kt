package com.eozsahin.feeddemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.R
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.theme.AppTypography
import com.google.accompanist.glide.rememberGlidePainter

@Preview
@Composable
fun UserProfile(
    profileImgUrl: String = "https://picsum.photos/300/300",
    userName: String = "Dexter Morgan",
    imageModifier: Modifier = Modifier,
    userNameStyle: TextStyle = AppTypography.body2,
    userTagStyle: TextStyle = AppTypography.caption
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(5.dp)
    ) {
        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_background), // FOR PREVIEW
            painter = rememberGlidePainter(
                profileImgUrl,
                fadeIn = true,
                previewPlaceholder = R.drawable.abc_vector_test
            ),
            contentDescription = "UserImage",
            modifier = imageModifier
        )
        Spacer(modifier = Modifier.padding(horizontal = 3.dp))
        Column(modifier = Modifier.padding(5.dp)) {
            Text(userName, style = userNameStyle)
            Text(
                "@${userName.split(" ")[0]}",
                style = userTagStyle,
                color = Color.Gray
            )
        }
    }
}