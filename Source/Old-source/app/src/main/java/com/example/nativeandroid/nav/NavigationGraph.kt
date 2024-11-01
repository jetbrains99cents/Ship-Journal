package com.example.nativeandroid.nav

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nativeandroid.*

//import com.example.nativeandroid.screens.*

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home_screen") {
        // Home screen route
        composable("home_screen") { HomeScreen(navController) }

        // Watch operation related screens
        composable("watch_date_selection_screen") { WatchDateSelectionScreen(navController) }
        composable("watch_person_moment_selection_screen") { WatchPersonMomentSelectionScreen(navController) }
        composable("watch_menu_selection_screen") { WatchMenuSelectionScreen(navController) }

        // Other operation related screens
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
}