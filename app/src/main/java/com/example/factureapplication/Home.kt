package com.example.factureapplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.factureapplication.ui.theme.DarkRed
import com.example.factureapplication.ui.theme.Grey
import com.example.factureapplication.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController){
    var quantity by remember {
        mutableStateOf("")
    }
    var unitprice by remember {
        mutableStateOf("")
    }
    var HTamount by remember {
        mutableStateOf("")
    }
    var TVA by remember {
        mutableStateOf("")
    }
    val fidelityOptions = listOf<String>("Fidèle", "Non Fidèle")
    var selectedFidelityOptions by remember {
        mutableStateOf(fidelityOptions[1])
    }
    var remise by remember {
        mutableStateOf("")
    }
    var CalculerEnabled by remember { mutableStateOf(false) }
    var RemiseEnabled by remember { mutableStateOf(false) }

    if (quantity.isNotEmpty() && unitprice.isNotEmpty() && HTamount.isNotEmpty() && TVA.isNotEmpty()){
        CalculerEnabled = true
    }



    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(color = Aniline)
    ){
        Text(
            text = "FACTURE",
            style = CustomTypography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            Modifier
                .height(25.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = quantity,
            onValueChange = {
                quantity=it;
                if (unitprice.isNotEmpty() && quantity.isNotEmpty()) {
                    HTamount = (unitprice.toInt() * quantity.toInt()).toString()
                }
            },
            label = { Label("Quantité") },
            textStyle = TextStyle(color = Color.White)
            )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = unitprice,
            onValueChange = {
                unitprice=it;
                if (unitprice.isNotEmpty() && quantity.isNotEmpty()) {
                    HTamount = (unitprice.toInt() * quantity.toInt()).toString()
                }
            },
            label = { Label("Prix unitaire") },
            textStyle = TextStyle(color = Color.White)
            )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = HTamount,
            onValueChange = { HTamount=it },
            label = { Label("Montant HT") },
            textStyle = TextStyle(color = Color.White)
            )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = TVA,
            onValueChange = { TVA=it },
            label = { Label("Taux TVA (%)") },
            textStyle = TextStyle(color = Color.White)
            )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
            fidelityOptions.forEach(){ optionName ->
                Row(verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = (optionName == selectedFidelityOptions),
                        onClick = {
                            selectedFidelityOptions = optionName
                            RemiseEnabled = optionName == "Fidèle"
                        },
                    )
                    Text(
                        text = optionName,
                        style = CustomTypography.labelSmall
                    )
                }
            }
        }
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = remise,
            onValueChange = { remise=it },
            label = { Label("Remise (%)") },
            enabled = RemiseEnabled,
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
        Row {
            ElevatedButton(
                onClick = {
                    var tvaAmount = HTamount.toInt() * (TVA.toDouble() / 100.0);
                    var total = HTamount.toDouble() + tvaAmount;
                    if (remise.isNotEmpty()) {
                        var remiseAmount = total * (remise.toDouble() / 100);
                        total -= remiseAmount;
                    }
                    navController.navigate("Calcul/${total.toString()}");
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor,
                    contentColor = Color.White,
                    disabledContainerColor = Grey
                ),
                enabled = CalculerEnabled
            ) {
                Text(text = "Calculer TTC", fontSize = 18.sp)
            }
            Spacer(
                Modifier
                    .width(25.dp)
            )
            ElevatedButton(
                onClick = {
                          quantity = "";
                          unitprice = "";
                          HTamount  = "";
                          TVA = "";
                          selectedFidelityOptions = fidelityOptions[1];
                          remise = "";
                          Log.d("calculTotal", "remise à zéro");
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkRed,
                )
            ) {
                Text(text = "Remise à zéro", fontSize = 18.sp)
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHome(){
    Home(navController = rememberNavController())
}