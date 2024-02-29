package com.example.factureapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.factureapplication.ui.theme.Aniline
import com.example.factureapplication.ui.theme.CustomTypography
import com.example.factureapplication.ui.theme.DarkBlack
import com.example.factureapplication.ui.theme.DarkGrey
import com.example.factureapplication.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calcul(navController: NavHostController, ttcAmount: String?) {

    var stringTtcAmount = ttcAmount.toString();

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(color = Aniline)
    ) {
        Text(
            text = "MONTANT TTC",
            style = CustomTypography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            Modifier
                .height(25.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = stringTtcAmount,
            onValueChange = {
                stringTtcAmount = it;
            },
            label = { Label("Montant") },
            enabled = false,
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledBorderColor = DarkBlack,
                disabledTextColor = DarkGrey,
                disabledLabelColor = DarkGrey,
            )
        )
        Spacer(
            Modifier
                .height(25.dp)
                .fillMaxSize()
        )
        ElevatedButton(
            onClick = {
                navController.navigate("Home");
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MainColor,
                contentColor = Color.White
            ),
        ) {
            Text(text = "Retour", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCalcul(){
    Calcul(navController = rememberNavController(), ttcAmount = "40.2")
}