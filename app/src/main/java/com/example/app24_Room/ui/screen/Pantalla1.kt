package com.example.app24_Room.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Pantalla1(){

    val vm: Pantalles_ViewModel = viewModel()
    val character by vm.character.collectAsStateWithLifecycle()
    val position by vm.position.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.getCharacters()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center // Esto centra la Column dentro del Box
    ) {
        Column(
            // Añadimos fillMaxWidth para que la columna use todo el ancho
            // No ponemos fillMaxSize aquí para que el Box gestione el centrado vertical
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Aquesta és la Pantalla 1", color = Color.Black)
            Text("Mirant de mostrar el registre: $position", color = Color.Black)

            // Nota: Es mejor evitar el uso de !! (double bang)
            val characterName = character?.name ?: "No s'ha trobat cap personatge"
            Text("El nom del character és: $characterName", color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp)) // Un poco de espacio antes de los botones

            Row(
                modifier = Modifier.fillMaxWidth(), // La fila debe ocupar el ancho para centrar contenido
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ButtonScreen("Previous") { vm.previous() }

                Spacer(modifier = Modifier.width(8.dp)) // Espacio entre botones

                ButtonScreen("Next") { vm.next() }
            }
        }
    }
}


@Composable
fun ButtonScreen(message:String, onNextClicked: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onNextClicked) {
            Text(text = message)
        }
    }
}



