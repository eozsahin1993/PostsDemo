package com.eozsahin.feeddemo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.eozsahin.feeddemo.ui.models.Comment
import com.eozsahin.feeddemo.ui.theme.AppTypography
import com.eozsahin.feeddemo.ui.theme.Red300

@Preview
@Composable
fun CommentView(@PreviewParameter(CommentProvider::class) comment: Comment) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 2.dp
    ) {
        Column {
            CommentBody(comment)
            Spacer(Modifier.height(5.dp))
            CommentFooter(comment)
        }
    }
}

@Composable
fun CommentBody(comment: Comment) {
    Text(
        comment.body,
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp)
    )
}

@Composable
fun CommentFooter(comment: Comment) {
    var liked = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { liked.value = !liked.value } ) {
            val icon = if (liked.value) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder
            Icon(icon, contentDescription = "", tint = Red300)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
               ,
            horizontalArrangement = Arrangement.End,
        ) {
            Text(comment.userName, style = AppTypography.subtitle2)
        }
    }


}

class CommentProvider: PreviewParameterProvider<Comment> {
    override val values = sequenceOf(Comment(
        id = 1,
        body = "Far far away, behind the word mountains, far from the countries Vokalia and " +
                "Consonantia, there live the blind texts. Separated they live in Bookmarksgrove " +
                "right at the coast of the Semantics, a large language ocean. ",
        userName = "Dexter Morgan",
        userImgUrl = ""
    ))
}