package com.example.ship_journal

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
import com.example.ship_journal.ui.theme.ShipJournalTheme

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

// New imports for DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat

import com.example.ship_journal.nav.NavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ShipJournalTheme {
                //HomeScreen()
                val navController = rememberNavController()
                NavigationGraph(navController)
            }
        }
    }
}

// Custom Button Model
@Composable
fun CustomButton(
    onClick: () -> Unit, text: String, modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick, modifier = modifier, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3))
    ) {
        Text(text = text)
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Top Bar
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
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
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val buttonWidth = Modifier.fillMaxWidth(0.8f) // 80% of the screen width
                    val buttonShape = RoundedCornerShape(16.dp) // More rounded corners

                    Button(
                        onClick = { navController.navigate("watch_date_selection_screen") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                        modifier = buttonWidth.padding(8.dp),
                        shape = buttonShape
                    ) {
                        Text(text = "Watch Screen", color = Color.White)
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

            // Bottom-right "LUNA NEXUS" text
            /*Text(
                text = "LUNA NEXUS",
                color = Color(0xFF2690A3),  // Custom color
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif, // Use your actual font if custom
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            )*/

            // Bottom-right Luna Nexus logo
            Image(
                painter = painterResource(id = R.drawable.luna_nexus_logo),
                contentDescription = "Luna Nexus Logo",
                modifier = Modifier.align(Alignment.BottomEnd).padding(6.dp).size(100.dp)
            )
        }
    }
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

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShipJournalTheme {
        Greeting("Android")
    }
}*/
