package com.iessanalberto.dam2.juegosdemanos.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iessanalberto.dam2.juegosdemanos.R
import com.iessanalberto.dam2.juegosdemanos.models.Player
import kotlin.random.Random

val player: Player = Player(
    puntuacion = 0
)
val enemy: Player = Player(
    puntuacion = 0
)
var resultado  : String = ""

@Composable
fun BodyContent( modifier: Modifier) {
    var isSelected by rememberSaveable { mutableStateOf(false)}
    var opcionJugador by rememberSaveable { mutableStateOf(0) }


    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row {
            Text(text = "Selecciona una de las 3 opciones")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Image(
                painter = painterResource(R.drawable.piedra),
                contentDescription = "Piedra",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .clickable { isSelected = !isSelected
                        opcionJugador=0
                    }
                    .border(width = 2.dp, color = if(opcionJugador==0) Color.Blue else Color.Gray, shape = CircleShape)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.papel),
                contentDescription = "Papel",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .clickable { isSelected = !isSelected
                    opcionJugador = 1
                    }
                    .border(width = 2.dp, color = if(opcionJugador==1) Color.Blue else Color.Gray, shape = CircleShape)


            )
            Spacer(modifier = Modifier.width(20.dp))

            Image(
                painter = painterResource(R.drawable.tijera),
                contentDescription = "Tijera",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .clickable { isSelected = !isSelected
                    opcionJugador = 2
                    }
                    .border(width = 2.dp, color = if(opcionJugador==2) Color.Blue else Color.Gray, shape = CircleShape)


            )

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {
            jugarPartida(opcionJugador)
            System.out.println(player.puntuacion.toString() + enemy.puntuacion.toString())
        }
        ){
            Text(text = "Jugar")
        }
    }
}


fun jugarPartida(opcionJugador:Int): String{

    var opcionMaquina = tiradaEnemy()

    if(opcionJugador-opcionMaquina==1||opcionJugador-opcionMaquina==-2){
        player.puntuacion++
        resultado = "Has ganado"
    }else if(opcionJugador-opcionMaquina==2||opcionJugador-opcionMaquina==-1){
        enemy.puntuacion++
        resultado = "Ha ganado la máquina"
    }
    resultado = "Empate"


    return resultado
}

fun tiradaEnemy():Int{
    val tiradaEnemy = Random.nextInt(1,4)
    return tiradaEnemy
}