package com.example.app24_Room.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Route: NavKey {
    @Serializable
    data object Pantalla1: Route()
    @Serializable
    data object Pantalla2: Route()
    @Serializable
    data object Pantalla3: Route()

    @Serializable
    data class DetailScreen(val id:Int): Route()

}
