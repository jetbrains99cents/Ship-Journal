package com.example.ship_journal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController

@Composable
fun JournalEntryMainEngineScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Preview Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 8.dp).weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Placeholder for preview content
            Text(
                text = "M/E",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // Centered Save Button
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate("home_screen") }, // Replace with actual home screen
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp)
                ) {
                    Text(text = "Save")
                }
            }
        }
    }
}

@Composable
fun JournalEntryAuxiliaryEngineScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Preview Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 8.dp).weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Placeholder for preview content
            Text(
                text = "A/E",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // Centered Save Button
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate("home_screen") }, // Replace with actual home screen
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp)
                ) {
                    Text(text = "Save")
                }
            }
        }
    }
}

@Composable
fun JournalEntryRefrigeratorScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Preview Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 8.dp).weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Placeholder for preview content
            Text(
                text = "REF",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // Centered Save Button
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate("home_screen") }, // Replace with actual home screen
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp)
                ) {
                    Text(text = "Save")
                }
            }
        }
    }
}

@Composable
fun JournalEntryTemperatureScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Preview Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 8.dp).weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Placeholder for preview content
            Text(
                text = "TEMP",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // Centered Save Button
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate("home_screen") }, // Replace with actual home screen
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp)
                ) {
                    Text(text = "Save")
                }
            }
        }
    }
}
