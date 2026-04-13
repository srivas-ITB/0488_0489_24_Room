package com.example.app24_Room.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app24_Room.entity.CharacterEntity

@Composable
fun Pantalla2() {

    val vm: Pantalles_ViewModel = viewModel()
    val error by vm.error.collectAsStateWithLifecycle()

    // Estados para los campos
    var idInput by remember { mutableStateOf("") }
    var nameInput by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.getCharacters()
    }


    Box(Modifier
        .fillMaxSize()
        .background(Color.Blue), contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text("Aquesta és la pantalla 2", color = Color.White)

            // Campo para el ID (Numérico)
            OutlinedTextField(
                value = idInput,
                onValueChange = { newValue ->
                    // Validación básica: solo permitimos números
                    if (newValue.all { it.isDigit() }) {
                        idInput = newValue
                    }
                },
                label = { Text("ID del Usuario") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Campo para el Nombre (Texto)
            OutlinedTextField(
                value = nameInput,
                onValueChange = { nameInput = it },
                label = { Text("Nombre Completo") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Button(onClick = { afegirCharacter(vm, Integer.parseInt(idInput), nameInput) }) {
                Text("Afegir Character")
            }

            if (error != "") {
                Text(error)
            }
        }
    }
}

fun afegirCharacter(vm: Pantalles_ViewModel, id: Int, nom: String) {

    val c: CharacterEntity = CharacterEntity(
        id,
        nom,
        "1971",
        "multicolor",
        "M",
        height = "186",
        "La Terra",
        "95",
        "http://linked-in.com/srivas"
    )

    vm.saveCharacter(c)
}
