package com.example.app24_Room.ui.navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.app24_Room.ui.screen.DetailScreen
import com.example.app24_Room.ui.screen.Pantalla1
import com.example.app24_Room.ui.screen.Pantalla2
import com.example.app24_Room.ui.screen.Pantalla3

@Composable
fun NavigationWrapper(){
    val backStack = rememberNavBackStack(Route.Pantalla1)
    val currentRoute = backStack.lastOrNull()
    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomBarItems.forEach { item ->
                    NavigationBarItem(
                        selected = (currentRoute == item.route),
                        onClick = {
                            if (currentRoute != item.route) {
                                backStack.clear()
                                backStack.add(item.route)
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }

        }
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Route.Pantalla1> { Pantalla1() }
                entry<Route.Pantalla2> { Pantalla2() }
                entry<Route.Pantalla3> { Pantalla3()
                     { id -> backStack.add(Route.DetailScreen(id)) }
                }
                entry<Route.DetailScreen> { it ->
                    DetailScreen(it.id) {
                        backStack.removeLastOrNull()
                    }
                }
            }
        )

    }
}

