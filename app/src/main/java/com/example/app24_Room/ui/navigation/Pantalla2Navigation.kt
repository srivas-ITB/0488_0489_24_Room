package com.example.app24_Room.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.app24_Room.ui.screen.Pantalla2
import com.example.app24_Room.ui.screen.Pantalla2_1

@Composable
fun Pantalla2Navigation() {
    val pantalla2BackStack = rememberNavBackStack(Pantalla2Route.Pantalla2)
    NavDisplay(
        backStack = pantalla2BackStack,
        onBack = { pantalla2BackStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Pantalla2Route.Pantalla2> {
                Pantalla2 { pantalla2BackStack.add(Pantalla2Route.Pantalla2_1) }
            }
            entry<Pantalla2Route.Pantalla2_1> {
                Pantalla2_1 { pantalla2BackStack.removeLastOrNull() }
            }
        }
    )
}
