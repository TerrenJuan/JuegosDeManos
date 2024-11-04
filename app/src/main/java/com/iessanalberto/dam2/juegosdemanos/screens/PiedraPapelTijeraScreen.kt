package com.iessanalberto.dam2.juegosdemanos.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.juegosdemanos.R
import com.iessanalberto.dam2.juegosdemanos.models.Player
import com.iessanalberto.dam2.juegosdemanos.navigation.AppScreens
import kotlin.random.Random

val player: Player = Player(
    puntuacion = 0
)
val enemy: Player = Player(
    puntuacion = 0
)
var resultado  : String = ""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PiedraPapelTijeraScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Piedra, papel o tijera") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary

                )
            )

        },

        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Atrás"
                        )
                    }
                    IconButton(onClick = {
                        player.puntuacion = 0
                        enemy.puntuacion = 0
                    }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Reiniciar")
                    }
                    Text(text = "Reiniciar Partida")
                }

            )
        },
        modifier = Modifier.fillMaxSize()



    ){
            paddingValues -> BodyContentPiedraPapelTijera(modifier = Modifier.padding(paddingValues))
    }




}
@Composable
fun BodyContentPiedraPapelTijera( modifier: Modifier) {
    var isSelected by rememberSaveable { mutableStateOf(false)}
    var opcionJugador by rememberSaveable { mutableStateOf(0) }
    val context = LocalContext.current

    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row {
        Text(text = "PUNTUACIÓN")
        }
        Row{
            Text(text="Player: ")
            Text(
                text = player.puntuacion.toString(),
                modifier = Modifier.width(200.dp),

            )
            Text(text="Enemy: ")
            Text(
                text = enemy.puntuacion.toString(),
                modifier = Modifier.width(200.dp),

                )
        }
        Spacer(modifier = Modifier.height(50.dp))
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

            Toast.makeText(context, jugarPartida(opcionJugador), Toast.LENGTH_SHORT).show()
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