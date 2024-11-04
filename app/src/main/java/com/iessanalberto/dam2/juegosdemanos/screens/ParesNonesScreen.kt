package com.iessanalberto.dam2.juegosdemanos.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.iessanalberto.dam2.juegosdemanos.models.Player
import kotlin.random.Random


@Composable
fun ParesNonesScreen(navController: NavController){

}


fun jugarParesNones(opcionJugador:Int): String{

    var opcionMaquina = Random.nextInt(0,2)

    if(opcionJugador-opcionMaquina==1){
        player.puntuacion++
        resultado = "Has ganado"
    }else if(opcionJugador-opcionMaquina==-1){
        enemy.puntuacion++
        resultado = "Ha ganado la máquina"
    }
    resultado = "Empate"


    return resultado
}

