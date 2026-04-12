package com.example.app24_Room.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarItem(val route: Route, val label: String, val icon: ImageVector) {
    data object Item1 : BottomBarItem(Route.Pantalla1, "Pantalla 1", Icons.Default.Home)
    data object Item2 : BottomBarItem(Route.Pantalla2, "Pantalla 2", Icons.Default.Person)
    data object Item3 : BottomBarItem(Route.Pantalla3, "Pantalla 3", Icons.Default.Settings)
}
val bottomBarItems = listOf(BottomBarItem.Item1, BottomBarItem.Item2, BottomBarItem.Item3)
