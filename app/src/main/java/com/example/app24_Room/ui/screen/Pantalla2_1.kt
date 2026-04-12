package com.example.app24_Room.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Pantalla2_1(navigateBack: () -> Unit){
    Box(Modifier.fillMaxSize().background(Color.Blue), contentAlignment = Alignment.Center){

        Column ( modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
        {
            Text("Aquesta és la pantalla 2.1", color = Color.White)

            Button(onClick = { navigateBack() }) {
                Text("Go back")
            }
        }
    }
}
