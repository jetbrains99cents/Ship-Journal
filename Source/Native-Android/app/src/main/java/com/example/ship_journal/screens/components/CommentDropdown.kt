package com.example.ship_journal.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun CommentDropdown(
    comments: List<String>
) {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var selectedComment by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedComment,
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isDropdownExpanded = true },
            label = { Text("Select Comment") },
            trailingIcon = {
                Icon(
                    if (isDropdownExpanded)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    "dropdown arrow"
                )
            },
            readOnly = true,
            enabled = false
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable { isDropdownExpanded = true }
        )

        DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = { isDropdownExpanded = false },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            comments.forEach { comment ->
                DropdownMenuItem(
                    text = { Text(comment) },
                    onClick = {
                        selectedComment = comment
                        isDropdownExpanded = false
                    }
                )
            }
        }
    }
}