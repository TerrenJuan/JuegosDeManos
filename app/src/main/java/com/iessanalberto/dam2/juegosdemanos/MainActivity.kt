package com.iessanalberto.dam2.juegosdemanos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.iessanalberto.dam2.juegosdemanos.navigation.AppNavigation
import com.iessanalberto.dam2.juegosdemanos.ui.theme.JuegosDeManosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JuegosDeManosTheme {
                AppNavigation()
            }
        }
    }
}


