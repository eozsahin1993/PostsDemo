package com.eozsahin.feeddemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Assignment
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Logout
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.R
import com.eozsahin.feeddemo.ui.models.Post
import com.eozsahin.feeddemo.ui.models.User
import com.eozsahin.feeddemo.ui.theme.AppTypography
import com.eozsahin.feeddemo.ui.viewmodels.HomeViewModel
import com.google.accompanist.glide.rememberGlidePainter

val drawerList = listOf(
    Pair(Icons.Rounded.Home, "Feed"),
    Pair(Icons.Rounded.Assignment, "My posts"),
    Pair(Icons.Rounded.Settings, "Settings"),
    Pair(Icons.Rounded.Logout, "Logout"))

@Composable
fun Drawer(model: HomeViewModel = HomeViewModel(), onOptionSelected: (String) -> Unit = {}) {
    DrawerContent(user = model.user.value, onOptionSelected = onOptionSelected)
}

@Preview(showBackground = true)
@Composable
fun DrawerContent(
    @PreviewParameter(UserProvider::class) user: User,
    onOptionSelected: (String) -> Unit = {}
) {
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)

        ) {
            DrawerUserProfile(user = user)
            DrawerOptions(onOptionSelected = onOptionSelected)
        }
    }
}

@Composable
fun DrawerUserProfile(@PreviewParameter(UserProvider::class) user: User) {
    Image(
//        painter = painterResource(id = R.drawable.ic_launcher_background), // FOR PREVIEW
        painter = rememberGlidePainter(
            user.profileImgUrl,
            fadeIn = true,
            previewPlaceholder = R.drawable.abc_vector_test
        ),
        contentDescription = "UserImage",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
    )
    Column(modifier = Modifier.padding(15.dp)) {
        Text(user.name, style = MaterialTheme.typography.h5)
        Text(
            "@${user.userName.split(" ")[0]}",
            style = MaterialTheme.typography.h6,
            color = Color.Gray
        )
    }
}

@Composable
fun DrawerOptions(onOptionSelected: (String) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 70.dp, top = 20.dp)
    ) {
        Spacer(Modifier.height(20.dp))
        for (screen in drawerList) {
            Spacer(Modifier.height(24.dp))
            Row(
                Modifier.clickable { onOptionSelected(screen.second) },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(screen.first, "", modifier = Modifier.size(30.dp))
                Spacer(Modifier.width(25.dp))
                Text(text = screen.second, style = MaterialTheme.typography.h5)
            }
        }
    }
}

class UserProvider: PreviewParameterProvider<User> {
    override val values = sequenceOf(getPreviewUser())

    private fun getPreviewUser() = User(
        id = 1,
        name = "Dexter Morgan",
        userName = "Dexter",
        email = "dexter.morgan@gmail.com",
        profileImgUrl = "https://randomuser.me/api/portraits/med/men/1.jpg"
    )
}