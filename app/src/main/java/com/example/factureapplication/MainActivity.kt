package com.example.factureapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.factureapplication.Nav
import com.example.factureapplication.ui.theme.CustomTypography
import com.example.factureapplication.ui.theme.DarkRed
import com.example.factureapplication.ui.theme.FactureApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FactureApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Nav()
                }
            }
        }
    }

}

@Composable
fun Title(title: String){

    Text(
        title,
        style = CustomTypography.bodyLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    )
}

@Composable
fun Label(label: String){
    Text(
        text = label,
        style = CustomTypography.labelSmall,
        modifier = Modifier
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    FactureApplicationTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Title("Facture")
        }
    }
}