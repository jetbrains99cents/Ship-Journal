package com.example.ship_journal.screens

import com.example.ship_journal.screens.components.*

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController

@Composable
fun JournalEntryMainEngineScreen(navController: NavHostController) {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var selectedComment by remember { mutableStateOf("") }

    val sampleComments = listOf(
        "All parameters normal",
        "High oil temperature noted",
        "Maintenance required",
        "Performance check completed",
        "Abnormal noise detected",
        "Routine inspection done",
        "Requires attention",
        "Operating at optimal levels"
    )

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Journal Entry - Main Engine Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Header and Dropdown section
            Column {
                Text(
                    text = "M/E",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Comments Dropdown
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = selectedComment,
                        onValueChange = { },  // Read only
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
                        sampleComments.forEach { comment ->
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

            Spacer(modifier = Modifier.height(16.dp))

            // Grid view for main engine input
            Box(
                modifier = Modifier
                    .weight(1f) // This will make the grid view take remaining space
                    .fillMaxWidth()
            ) {
                val titles = listOf("No", "Item", "Value")

                var contents by remember {
                    mutableStateOf(listOf(
                        "Engine Oil", "5",
                        "Fuel Filter", "2",
                        "Air Filter", "1",
                        "Cylinder Oil", "10",
                        "Oil Filter", "4",
                        "Fuel Injector", "6",
                        "Piston Ring", "12",
                        "Bearing Shell", "8",
                        "Gasket Set", "3",
                        "Coolant", "20",
                        "O-Ring Set", "15",
                        "Safety Valve", "2",
                        "Hydraulic Oil", "8",
                        "Grease", "10",
                        "Belt", "4",
                        "Pump Seal", "6",
                        "Coupling", "2",
                        "Thermostat", "3",
                        "Water Filter", "5"
                    ))
                }

                JournalEntryGridView(
                    columnTitles = titles,
                    contents = contents,
                    onItemChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2, newValue)
                        }
                    },
                    onQtyChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2 + 1, newValue.toString())
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Complete and Return buttons at the bottom
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigateUp() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C757D)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Return")
                }

                Button(
                    onClick = {6
                        // Handle save operation here
                        navController.navigate("watch_menu_selection_screen")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Complete")
                }
            }
        }
    }
}

@Composable
fun JournalEntryAuxiliaryEngineScreen(navController: NavHostController) {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var selectedComment by remember { mutableStateOf("") }

    val sampleComments = listOf(
        "All parameters normal",
        "High oil temperature noted",
        "Maintenance required",
        "Performance check completed",
        "Abnormal noise detected",
        "Routine inspection done",
        "Requires attention",
        "Operating at optimal levels"
    )

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Journal Entry - Auxiliary Engine Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Header and Dropdown section
            Column {
                Text(
                    text = "A/E",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Comments Dropdown
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = selectedComment,
                        onValueChange = { },  // Read only
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
                        sampleComments.forEach { comment ->
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

            Spacer(modifier = Modifier.height(16.dp))

            // Grid view area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                val titles = listOf("No", "Item", "Value")
                var contents by remember {
                    mutableStateOf(listOf(
                        "Lube Oil Pressure", "4.2",
                        "Cooling Water Temp", "85",
                        "RPM", "720",
                        "Load", "65",
                        "Fuel Rack Position", "18",
                        "Exhaust Gas Temp", "380",
                        "Turbocharger RPM", "21000",
                        "Starting Air Pressure", "30",
                        "Oil Sump Level", "95",
                        "Fuel Oil Pressure", "8"
                    ))
                }

                JournalEntryGridView(
                    columnTitles = titles,
                    contents = contents,
                    onItemChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2, newValue)
                        }
                    },
                    onQtyChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2 + 1, newValue.toString())
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Complete and Return buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigateUp() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C757D)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Return")
                }

                Button(
                    onClick = {
                        navController.navigate("watch_menu_selection_screen")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Complete")
                }
            }
        }
    }
}

@Composable
fun JournalEntryRefrigeratorScreen(navController: NavHostController) {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var selectedComment by remember { mutableStateOf("") }

    val sampleComments = listOf(
        "All temperatures within range",
        "Temperature fluctuation noted",
        "Defrosting required",
        "Regular maintenance completed",
        "Temperature adjustment needed",
        "System running efficiently",
        "Check compressor operation",
        "Regular inspection completed"
    )

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Journal Entry - Refrigerator Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Header and Dropdown section
            Column {
                Text(
                    text = "REF",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Comments Dropdown
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = selectedComment,
                        onValueChange = { },  // Read only
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
                        sampleComments.forEach { comment ->
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

            Spacer(modifier = Modifier.height(16.dp))

            // Grid view area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                val titles = listOf("No", "Item", "Value")
                var contents by remember {
                    mutableStateOf(listOf(
                        "Provision Cold Room", "-18",
                        "Vegetable Room", "4",
                        "Meat Room", "-22",
                        "Fish Room", "-25",
                        "Dairy Room", "2",
                        "Freeze Room #1", "-20",
                        "Freeze Room #2", "-20",
                        "Service Room", "5",
                        "Compressor Room", "28",
                        "Pre-Cooling Room", "-5"
                    ))
                }

                JournalEntryGridView(
                    columnTitles = titles,
                    contents = contents,
                    onItemChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2, newValue)
                        }
                    },
                    onQtyChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2 + 1, newValue.toString())
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Complete and Return buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigateUp() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C757D)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Return")
                }

                Button(
                    onClick = {
                        navController.navigate("watch_menu_selection_screen")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Complete")
                }
            }
        }
    }
}

@Composable
fun JournalEntryTemperatureScreen(navController: NavHostController) {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var selectedComment by remember { mutableStateOf("") }

    val sampleComments = listOf(
        "All areas within normal range",
        "High temperature in engine room",
        "AC system checked",
        "Ventilation working properly",
        "Temperature deviation noted",
        "Regular monitoring completed",
        "Requires ventilation adjustment",
        "Temperature stable in all areas"
    )

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Top Bar with Icon and Centered Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.example.ship_journal.R.drawable.ic_monitor),
                    contentDescription = "Monitor Icon",
                    modifier = Modifier.size(40.dp)
                )

                Text(
                    text = "Journal Entry - Temperature Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Header and Dropdown section
            Column {
                Text(
                    text = "TEMP",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Comments Dropdown
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = selectedComment,
                        onValueChange = { },  // Read only
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
                        sampleComments.forEach { comment ->
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

            Spacer(modifier = Modifier.height(16.dp))

            // Grid view area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                val titles = listOf("No", "Item", "Value")
                var contents by remember {
                    mutableStateOf(listOf(
                        "Engine Room", "38",
                        "Main Deck", "32",
                        "Bridge", "24",
                        "Cargo Hold #1", "28",
                        "Cargo Hold #2", "29",
                        "Cargo Hold #3", "27",
                        "Pump Room", "34",
                        "ECR", "26",
                        "Accommodation", "23",
                        "Workshop", "30",
                        "Galley", "28",
                        "Store Room", "25"
                    ))
                }

                JournalEntryGridView(
                    columnTitles = titles,
                    contents = contents,
                    onItemChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2, newValue)
                        }
                    },
                    onQtyChange = { index, newValue ->
                        contents = contents.toMutableList().apply {
                            set(index * 2 + 1, newValue.toString())
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Complete and Return buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigateUp() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C757D)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Return")
                }

                Button(
                    onClick = {
                        navController.navigate("watch_menu_selection_screen")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Complete")
                }
            }
        }
    }
}
