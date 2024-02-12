package com.example.factureapplication.redirection

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.factureapplication.redirection.layoutOne
import com.example.factureapplication.redirection.layoutThree
import com.example.factureapplication.redirection.layoutTwo

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Layout1") {
        composable(route = "Layout1") {
            layoutOne(navController)
        }
        composable(route = "Layout2") {
            layoutTwo(navController)
        }
        composable(route = "Layout3") {
            layoutThree(navController)
        }
    }
}