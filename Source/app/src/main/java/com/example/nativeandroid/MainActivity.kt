package com.example.nativeandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
import com.example.nativeandroid.ui.theme.NativeAndroidTheme

import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ButtonDefaults
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.times

import com.example.nativedandroid.nav.NavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            NativeAndroidTheme {
                //HomeScreen()
                val navController = rememberNavController()
                NavigationGraph(navController)
            }
        }
    }
}
/*@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home_screen") {
        // Homescreen route
        composable("home_screen") { HomeScreen(navController) }

        // Watch operation related screens
        composable("watch_date_selection_screen") { WatchDateSelectionScreen(navController) }
        composable("watch_person_moment_selection_screen") { WatchPersonMomentSelectionScreen(navController) }
        composable("watch_menu_selection_screen") { WatchMenuSelectionScreen(navController) }
        composable("journal_entry_screen") { JournalEntryScreen(navController) }
        composable("preview_screen") { PreviewScreen(navController) }
        composable("check_catch_quantity_screen") { CheckCatchQuantityScreen(navController) }
        composable("fo_remaining_screen") { FORemainingScreen(navController) }

        // Maintenance operation related screens
        composable("maintenance_screen") { MaintenanceScreen() }

        // Watch table operation related screens
        composable("watch_table_screen") { WatchTableScreen() }

        // Graph creation operation related screens
        composable("graph_creation_screen") { GraphCreationScreen() }

        // Setting operation related screens
        composable("setting_screen") { SettingScreen() }
    }
}*/

// Custom Button Model
@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3))
    ) {
        Text(text = text)
    }
}

// Homescreen definition
@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Home Icon
                Image(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(40.dp)
                )

                // Logos
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo_1),
                        contentDescription = "Logo 1",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo_2),
                        contentDescription = "Logo 2",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            // Center Buttons
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val buttonWidth = Modifier.fillMaxWidth(0.8f) // 80% of the screen width
                val buttonShape = RoundedCornerShape(16.dp) // More rounded corners

                Button(
                    onClick = { navController.navigate("watch_date_selection_screen") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                    modifier = buttonWidth.padding(8.dp),
                    shape = buttonShape
                ) {
                    Text(text = "Watch Screen", color = Color.White) // Set text color to contrast
                }
                Button(
                    onClick = { navController.navigate("maintenance_screen") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = buttonWidth.padding(8.dp),
                    shape = buttonShape
                ) {
                    Text(text = "Maintenance Screen", color = Color.White)
                }
                Button(
                    onClick = { navController.navigate("watch_table_screen") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = buttonWidth.padding(8.dp),
                    shape = buttonShape
                ) {
                    Text(text = "Watch Table", color = Color.White)
                }
                Button(
                    onClick = { navController.navigate("graph_creation_screen") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = buttonWidth.padding(8.dp),
                    shape = buttonShape
                ) {
                    Text(text = "Graph Creation", color = Color.White)
                }
                Button(
                    onClick = { navController.navigate("setting_screen") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                    modifier = buttonWidth.padding(8.dp),
                    shape = buttonShape
                ) {
                    Text(text = "Setting", color = Color.White)
                }
            }
        }
    }
}

// Watch related screens definition
@Composable
fun WatchDateSelectionScreen(navController: NavHostController) {

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
                    painter = painterResource(id = R.drawable.ic_monitor),
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

@Composable
fun WatchPersonMomentSelectionScreen(navController: NavHostController) {
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
                    painter = painterResource(id = R.drawable.ic_monitor),
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

            // Placeholder for content (e.g., moments or other information)
            Text(
                text = "Select a moment for the person.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

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
                    painter = painterResource(id = R.drawable.ic_monitor), // Replace with your actual icon resource
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
                    onClick = { navController.navigate("journal_entry_screen") }, // Replace with actual destination
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
fun JournalEntryScreen(navController: NavHostController) {
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
                    painter = painterResource(id = R.drawable.ic_monitor), // Replace with your actual icon resource
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

            // Placeholder for journal entry content
            Text(
                text = "Enter your journal entry here.",
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
                    painter = painterResource(id = R.drawable.ic_monitor),
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
                    painter = painterResource(id = R.drawable.ic_monitor),
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
                    painter = painterResource(id = R.drawable.ic_monitor),
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

// Maintenance related screens definition
@Composable
fun MaintenanceScreen() {
    Text("Maintenance Screen")
}

// Watch table related screens definition
@Composable
fun WatchTableScreen() {
    Text("Watch Table Screen")
}

// Graph creation related screens definition
@Composable
fun GraphCreationScreen() {
    Text("Graph Creation Screen")
}

// Setting related screen definition
@Composable
fun SettingScreen() {
    Text("Setting Screen")
}

// Old
//setContent {
//    NativeAndroidTheme {
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            Greeting(
//                name = "Android",
//                modifier = Modifier.padding(innerPadding)
//            )
//        }
//    }
//}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello. My name is $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NativeAndroidTheme {
//        Greeting("Android")
//    }
//}