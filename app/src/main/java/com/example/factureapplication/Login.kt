package com.example.factureapplication

import android.content.Context
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import com.example.factureapplication.ui.theme.ButtonCustom
import com.example.factureapplication.ui.theme.CustomTypography
import com.example.factureapplication.ui.theme.DarkBlack


@Composable
fun Login(navController: NavHostController){
    var loginValue by remember {
        mutableStateOf("")
    }
    var mdpValue by remember {
        mutableStateOf("")
    }
    val mContext = LocalContext.current
    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
        Text(
            text = "Connexion",
            style = CustomTypography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            Modifier
                .height(25.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = loginValue,
            onValueChange = { loginValue=it },
            label = { Label("Identifiant") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = mdpValue,
            onValueChange = { mdpValue=it },
            label = { Label("Mot de passe") },
            //keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
            //    keyboardType = KeyboardType.Password
            //)
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        ElevatedButton(
            onClick = {
                if (loginValue == "etudiant" && mdpValue == "AzertY") {
                    mToast(mContext, "Authentification réussi")
                    navController.navigate("Home")
                } else {
                    mToast(mContext, "Authentification invalide")
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlack,
            )
        ) {
            Text(text = "Se connecter", fontSize = 20.sp)
        }    }
}

private fun mToast(context: Context, text: String){
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

    @Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLogin(){
    Login(navController = rememberNavController())
}