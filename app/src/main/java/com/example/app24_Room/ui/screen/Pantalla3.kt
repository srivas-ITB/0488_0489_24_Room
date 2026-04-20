package com.example.app24_Room.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app24_Room.R
import com.example.app24_Room.entity.CharacterEntity
import kotlinx.coroutines.launch

//@Composable
//fun Pantalla3(navigateToDetail: (Int) -> Unit) {
//    Box(Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center) {
//
//        Text("Aquesta és la Pantalla 3", color = Color.Black)
//
//    }
//}


@Composable
fun Pantalla3(navigateToDetail: (Int) -> Unit) {
    //val rvState = rememberLazyListState()
    val rvState = rememberLazyGridState()

    val vm: Pantalles_ViewModel = viewModel()
    val charactersList by vm.charactersList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.getCharacters()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        //LazyColumn(state = rvState, modifier = Modifier.fillMaxSize()
        LazyVerticalGrid(state = rvState, columns = GridCells.Adaptive(600.dp)) {
            items(charactersList) { character ->
                CharacterItem(character = character, { navigateToDetail(character.id) })
            }
        }
        val showButton by remember { derivedStateOf { rvState.firstVisibleItemIndex > 0 } }
        val coroutineScope = rememberCoroutineScope()
        if (showButton) {
            Button(onClick = {
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }
            }, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)) {
                Icon(painterResource(id = android.R.drawable.arrow_up_float), "Up")
            }
        }

    }
}


@Composable
fun CharacterItem(character: CharacterEntity, navigateToDetail: (Int) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navigateToDetail(character.id) }
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(R.drawable.lego_yoda),
                contentDescription = character.name,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
                    .size(100.dp),
                contentScale = ContentScale.Fit
            )
            Column {
                Text(character.name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Text(text = "Id: ${character.id}")
            }
        }
    }
}

