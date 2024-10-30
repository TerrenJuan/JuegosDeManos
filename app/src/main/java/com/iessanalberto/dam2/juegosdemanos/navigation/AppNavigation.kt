package com.iessanalberto.dam2.juegosdemanos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iessanalberto.dam2.juegosdemanos.screens.MainScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route)
    {
        composable (route = AppScreens.MainScreen.route){ MainScreen(navController) }
        composable (route = AppScreens.ParesNonesScreen.route){ }
        composable (route = AppScreens.PiedraPapelTijeraScreen.route){ }
    }


}
