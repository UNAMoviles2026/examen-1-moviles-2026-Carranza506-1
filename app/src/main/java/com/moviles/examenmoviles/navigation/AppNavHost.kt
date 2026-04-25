package com.moviles.examenmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.moviles.examenmoviles.data.mockSpaces
import com.moviles.examenmoviles.ui.screens.DetailScreen
import com.moviles.examenmoviles.ui.screens.HomeScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onSpaceClick = { spaceId ->
                    navController.navigate("detail/$spaceId")
                }
            )
        }

        composable(
            route = "detail/{spaceId}",
            arguments = listOf(
                navArgument("spaceId") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val spaceId = backStackEntry.arguments?.getInt("spaceId")

            val space = mockSpaces.find { it.id == spaceId }

            if (space != null) {
                DetailScreen(
                    space = space,
                    onNavigateHome = {
                        navController.navigate("home")
                    }
                )
            }
        }
    }
}