package com.example.ship_journal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
//import androidx.compose.foundation.layout.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController
import java.text.SimpleDateFormat
import java.util.*

// Modal date picker definition
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

// Grid view card
@Composable
fun GridMiniPreviewCard(
    title: String,
    onClick: () -> Unit // onClick parameter for navigation
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Card(
        modifier = Modifier
            .width(0.45f * screenWidth) // 45% of screen width
            .height(0.4f * screenHeight) // 40% of screen height
            .clickable { onClick() } // Make the card clickable
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

// Date selection screen definition
@Composable
fun WatchDateSelectionScreen(navController: NavHostController) {
    // State to control the visibility of the date picker
    var showDatePicker by remember { mutableStateOf(true) }
    var selectedDate by remember { mutableStateOf<Long?>(null) }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center // Center the title in the row
            ) {
                // Monitor Icon
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                // Title Text
                Text(
                    text = "Watch Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp) // Space between icon and text
                        .weight(1f), // Allow text to take available space
                    textAlign = TextAlign.Center // Center text within its space
                )
            }

            // Show Date Picker Modal directly
            if (showDatePicker) {
                DatePickerModal(
                    onDateSelected = { dateMillis ->
                        selectedDate = dateMillis
                        showDatePicker = false // Hide the picker after selecting date
                    },
                    onDismiss = { showDatePicker = false }
                )
            }

            // Display the selected date
            selectedDate?.let {
                val formattedDate = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(it)
                Text(
                    text = "Selected Date: $formattedDate",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            } ?: run {
                Text(
                    text = "No date selected",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }

            // Bottom Row with Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // First Button
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp) // 40% of screen width
                ) {
                    Text(text = "Return")
                }

                // Second Button
                Button(
                    onClick = { navController.navigate("watch_person_moment_selection_screen") }, // Replace with actual destination
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp) // 40% of screen width
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

// Person on duty
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchPersonMomentSelectionScreen(navController: NavHostController) {
    // Sample data for the dropdown list
    val persons = listOf("Alice", "Bob", "Charlie", "David")
    val hours = (2..24 step 2).map { it.toString() } // Generate hours from 2 to 24 with 2 hrs step

    // State variables to hold selected values
    var selectedPerson by remember { mutableStateOf(persons[0]) }
    var selectedHour by remember { mutableStateOf(hours[0]) }
    var expandedPersonDropdown by remember { mutableStateOf(false) }
    var expandedHourDropdown by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center // Center the title in the row
            ) {
                // Monitor Icon
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                // Title Text
                Text(
                    text = "Watch Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp) // Space between icon and text
                        .weight(1f), // Allow text to take available space
                    textAlign = TextAlign.Center // Center text within its space
                )
            }

            // Text "Person on duty"
            Text(
                text = "Person on duty",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // A dropdown for selecting person from the person list
            ExposedDropdownMenuBox(
                expanded = expandedPersonDropdown,
                onExpandedChange = { expandedPersonDropdown = !expandedPersonDropdown }
            ) {
                TextField(
                    readOnly = true,
                    value = selectedPerson,
                    onValueChange = {},
                    label = { Text("Select Person") },
                    trailingIcon = {
                        Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
                    },
                    modifier = Modifier.fillMaxWidth(0.8f).menuAnchor() // Add menuAnchor() modifier
                )

                ExposedDropdownMenu(
                    expanded = expandedPersonDropdown,
                    onDismissRequest = { expandedPersonDropdown = false }
                ) {
                    persons.forEach { person ->
                        DropdownMenuItem(
                            text = { Text(person) },  // Use text parameter
                            onClick = {
                                selectedPerson = person
                                expandedPersonDropdown = false
                            }
                        )
                    }
                }
            }

            // Text "Moment"
            Text(
                text = "Moment",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // A dropdown for selecting moment from the moment list
            ExposedDropdownMenuBox(
                expanded = expandedHourDropdown,
                onExpandedChange = { expandedHourDropdown = !expandedHourDropdown }
            ) {
                TextField(
                    readOnly = true,
                    value = selectedHour,
                    onValueChange = {},
                    label = { Text("Select Moment") },
                    trailingIcon = {
                        Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
                    },
                    modifier = Modifier.fillMaxWidth(0.8f).menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expandedHourDropdown,
                    onDismissRequest = { expandedHourDropdown = false }
                ) {
                    hours.forEach { hour ->
                        DropdownMenuItem(
                            text = { Text("$hour hours") },
                            onClick = {
                                selectedHour = hour
                                expandedHourDropdown = false
                            }
                        )
                    }
                }
            }

            // Bottom Row with Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // First Button
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp) // 40% of screen width
                ) {
                    Text(text = "Return")
                }

                // Second Button
                Button(
                    onClick = { navController.navigate("watch_menu_selection_screen") }, // Replace with actual destination
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp) // 40% of screen width
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun WatchMenuSelectionScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center // Center the title in the row
            ) {
                // Monitor Icon
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor), // Replace with your actual icon resource
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                // Title Text
                Text(
                    text = "Watch Menu Selection",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp) // Space between icon and text
                        .weight(1f), // Allow text to take available space
                    textAlign = TextAlign.Center // Center text within its space
                )
            }

            // Button List
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Button for Journal Entry
                Button(
                    onClick = { navController.navigate("journal_entry_menu_screen") }, // Replace with actual destination
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Text(text = "Journal Entry")
                }

                // Button for Preview Screen
                Button(
                    onClick = { navController.navigate("preview_screen") }, // Replace with actual destination
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Text(text = "Preview Screen")
                }

                // Button for Check Catch Quantity
                Button(
                    onClick = { navController.navigate("check_catch_quantity_screen") }, // Replace with actual destination
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Text(text = "Check Catch Quantity")
                }

                // Button for FO Remaining
                Button(
                    onClick = { navController.navigate("fo_remaining_screen") }, // Replace with actual destination
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Text(text = "FO Remaining")
                }
            }

            // Centered Row with Top Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                // Centered Top Button
                Button(
                    onClick = { navController.navigate("home_screen") }, // Replace with actual home screen
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = Modifier.width(0.4f * LocalConfiguration.current.screenWidthDp.dp.value.dp) // 40% of screen width
                ) {
                    Text(text = "Top")
                }
            }
        }
    }
}

@Composable
fun JournalEntryMenuScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // Monitor Icon
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor), // Replace with your actual icon resource
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                // Title Text
                Text(
                    text = "Journal Entry",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Display 4 texts for 4 mini grid views to 4 sides on the screens, : M/E, A/E, REF, TEMP
            // Display 4 mini grid views of 4 entries to 4 sides on the screen, every view is below to according text: M/E, A/E, REF, TEMP
            // When touch/click on mini view, we switch to a larger screen that displays full of grid/sheet view
            Column {
                // Display M/E and A/E grid views
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GridMiniPreviewCard("M/E", onClick = { navController.navigate("preview_screen")}) // Navigate on click
                    GridMiniPreviewCard("A/E", onClick = { navController.navigate("preview_screen")}) // Navigate on click
                }
                // Display REF and TEMP grid views
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GridMiniPreviewCard("REF", onClick = { navController.navigate("preview_screen")}) // Navigate on click
                    GridMiniPreviewCard("TEMP", onClick = { navController.navigate("preview_screen")}) // Navigate on click
                }
            }

            // Centered Save Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
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
fun PreviewScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Placeholder for preview content
            Text(
                text = "Preview your content here.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // Centered Save Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
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
fun CheckCatchQuantityScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Check Catch Quantity",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Placeholder for catch quantity content
            Text(
                text = "Check the catch quantity here.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // Centered Save Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
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
fun FORemainingScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "FO Remaining",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Placeholder for FO remaining content
            Text(
                text = "View FO remaining here.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            // Centered Save Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
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