package com.example.factureapplication.redirection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.factureapplication.ui.theme.FactureApplicationTheme

@Composable
fun layoutTwo(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenue sur l'écran 2",
            fontSize = 17.sp,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(65.dp))

        ElevatedButton(onClick = {
            navController.navigate("Layout3")
        }) {
            Text(text = "Aller à l'écran 3", fontSize = 30.sp)
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Layout2Preview() {
    FactureApplicationTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            layoutTwo(navController = rememberNavController())
        }
    }
}