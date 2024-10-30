package com.example.nativeandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            NativeAndroidTheme {
                HomeScreen()
            }
        }
    }

    @Composable
    fun HomeScreen() {
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
                        onClick = { /* Handle Watch Screen action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)), // Custom background color
                        modifier = buttonWidth.padding(8.dp),
                        shape = buttonShape
                    ) {
                        Text(text = "Watch Screen", color = Color.White) // Set text color to contrast
                    }
                    Button(
                        onClick = { /* Handle Maintenance Screen action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                        modifier = buttonWidth.padding(8.dp),
                        shape = buttonShape
                    ) {
                        Text(text = "Maintenance Screen", color = Color.White)
                    }
                    Button(
                        onClick = { /* Handle Watch Table action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                        modifier = buttonWidth.padding(8.dp),
                        shape = buttonShape
                    ) {
                        Text(text = "Watch Table", color = Color.White)
                    }
                    Button(
                        onClick = { /* Handle Graph Creation action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2690A3)),
                        modifier = buttonWidth.padding(8.dp),
                        shape = buttonShape
                    ) {
                        Text(text = "Graph Creation", color = Color.White)
                    }
                    Button(
                        onClick = { /* Handle Setting Screen action */ },
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