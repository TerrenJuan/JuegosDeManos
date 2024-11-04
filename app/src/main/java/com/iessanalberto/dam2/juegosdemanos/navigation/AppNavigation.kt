package com.iessanalberto.dam2.juegosdemanos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iessanalberto.dam2.juegosdemanos.screens.MainScreen
import com.iessanalberto.dam2.juegosdemanos.screens.ParesNonesScreen
import com.iessanalberto.dam2.juegosdemanos.screens.PiedraPapelTijeraScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.PiedraPapelTijeraScreen.route)
    {
        composable (route = AppScreens.MainScreen.route){ MainScreen(navController) }
        composable (route = AppScreens.ParesNonesScreen.route){ ParesNonesScreen(navController) }
        composable (route = AppScreens.PiedraPapelTijeraScreen.route){ PiedraPapelTijeraScreen(navController)}
    }


}
