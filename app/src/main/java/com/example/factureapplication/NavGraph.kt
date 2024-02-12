package com.example.factureapplication

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
    NavHost(navController = navController, startDestination = "Login") {
        composable(route = "Login") {
            Login(navController)
        }
        composable(route = "Home") {
            Home(navController)
        }
    }
}