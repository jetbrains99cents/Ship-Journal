package com.example.ship_journal.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times

// Grid view card
@Composable
fun GridMiniPreviewCard(
    title: String, onClick: () -> Unit // onClick parameter for navigation
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    var commentText by remember { mutableStateOf("") } // State for comment input

    Card(modifier = Modifier.width(0.45f * screenWidth) // 45% of screen width
        .height(0.35f * screenHeight) // 40% of screen height
        .clickable { onClick() } // Make the card clickable
    ) {
        // Text for title
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp),
            style = TextStyle(fontSize = 12.sp) // Set font size and weight
        )

        // TextField for comment input
        TextField(
            value = commentText,
            onValueChange = { commentText = it },
            placeholder = { Text(text = "Comment", style = TextStyle(fontSize = 16.sp)) }, // Set placeholder font size
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp),
            textStyle = TextStyle(fontSize = 10.sp) // Set text field font size
        )

        Spacer(modifier = Modifier.height(8.dp)) // Space between text and image

        Image(
            painter = painterResource(id = com.example.ship_journal.R.drawable.ic_grid_thumbnail),
            contentDescription = "Thumbnail Icon",
            modifier = Modifier.fillMaxWidth() // Stretch image to fill the width
                .weight(1f) // Fill remaining height
        )
    }
}