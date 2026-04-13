package com.example.app24_Room.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app24_Room.entity.CharacterEntity

@Composable
fun Pantalla2() {

    val vm: Pantalla1_ViewModel = viewModel()
    val character by vm.character.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.getCharacters()
    }


    Box(Modifier.fillMaxSize().background(Color.Blue), contentAlignment = Alignment.Center){

        Column ( modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
        {
            Text("Aquesta és la pantalla 2", color = Color.White)



                Button(onClick = {afegirCharacter(vm)} ) {
                    Text("Afegir Character")
                }
        }
    }
}

fun afegirCharacter(vm: Pantalla1_ViewModel) {

    val c : CharacterEntity = CharacterEntity( 150, "Santi", "1971", "multicolor", "M", height = "186",  "La Terra", "95", "http://linked-in.com/srivas")

    vm.saveCharacter(c)
}
