package com.example.ship_journal.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun JournalEntryGridView(
    columnTitles: List<String> = emptyList(),
    contents: List<String>,
    onItemChange: (Int, String) -> Unit,
    onQtyChange: (Int, Int) -> Unit
) {
    val rowCount = contents.size / 2

    Column(modifier = Modifier.fillMaxWidth()) {
        // Column titles
        Row(modifier = Modifier.fillMaxWidth()) {
            columnTitles.forEachIndexed { index, title ->
                Box(
                    modifier = Modifier
                        .weight(
                            when (index) {
                                0 -> 0.5f // No column
                                1 -> 1.5f // Item column
                                else -> 1f // Qty column
                            }
                        )
                        .border(1.dp, Color.Gray)
                        .background(Color.LightGray)
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(title)
                }
            }
        }

        // Grid content
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(rowCount * 3) { index ->
                val row = index / 3
                val col = index % 3

                Box(
                    modifier = Modifier
                        .border(1.dp, Color.Gray)
                        .background(Color.White)
                        .height(60.dp)
                        .then(
                            when (col) {
                                0 -> Modifier.fillMaxWidth(0.15f) // No column
                                1 -> Modifier.fillMaxWidth(0.5f)  // Item column
                                else -> Modifier.fillMaxWidth(0.35f) // Qty column
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    when (col) {
                        0 -> { // No column
                            Text(
                                text = "${row + 1}"
                            )
                        }
                        1 -> { // Item column
                            var itemText by remember { mutableStateOf(contents[row * 2]) }
                            TextField(
                                value = itemText,
                                onValueChange = { newValue ->
                                    itemText = newValue
                                    onItemChange(row, newValue)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                ),
                                singleLine = true
                            )
                        }
                        2 -> { // Qty column
                            var qtyText by remember { mutableStateOf(contents[row * 2 + 1]) }
                            TextField(
                                value = qtyText,
                                onValueChange = { newValue ->
                                    newValue.toIntOrNull()?.let { qty ->
                                        qtyText = newValue
                                        onQtyChange(row, qty)
                                    }
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                ),
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )
                        }
                    }
                }
            }
        }
    }
}


