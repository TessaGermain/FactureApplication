package com.example.factureapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login") {
        composable(route = "Login") {
            Login(navController)
        }
        composable(route = "Home") {
            Home(navController)
        }
        composable(
            route = "Calcul/{ttcAmount}",
            arguments = listOf(navArgument("ttcAmount") { type = NavType.StringType })
        ) {
            backstraEntry ->
                Calcul(navController, ttcAmount = backstraEntry.arguments?.getString("ttcAmount"))
        }
    }
}