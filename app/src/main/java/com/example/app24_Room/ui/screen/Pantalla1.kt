package com.example.app24_Room.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Pantalla1(){

    val vm: Pantalla1_ViewModel = viewModel()
    val character by vm.character.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.getCharacters()
    }

    Box(Modifier.fillMaxSize().background(Color.Yellow), contentAlignment = Alignment.Center){
        Column( modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Aquesta és la Pantalla 1", color = Color.Black)

            if (character==null) {
                Text("No s'ha trobat cap personatge", color = Color.Black)
            }
            else {
                Text("El nom del character és: ${character!!.name}", color = Color.Black)
            }

        }
    }
}
