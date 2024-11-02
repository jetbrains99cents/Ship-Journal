package com.example.ship_journal.nav

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ship_journal.screens.*
import com.example.ship_journal.*

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
        composable("journal_entry_menu_screen") { JournalEntryMenuScreen(navController) }
        composable("journal_entry_main_engine_screen") { JournalEntryMainEngineScreen(navController) }
        composable("journal_entry_auxiliary_engine_screen") { JournalEntryAuxiliaryEngineScreen(navController) }
        composable("journal_entry_refrigerator_screen") { JournalEntryRefrigeratorScreen(navController) }
        composable("journal_entry_temperature_screen") { JournalEntryTemperatureScreen(navController) }
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