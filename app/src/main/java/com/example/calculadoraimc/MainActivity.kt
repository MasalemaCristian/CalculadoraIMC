package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.net.URLEncoder
import java.nio.charset.StandardCharsets



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CalculadoraIMC()
            }
        }
    }
}

@Composable
fun CalculadoraIMC() {
    PantallaInicio()
}

@Composable
fun PantallaInicio() {

    var nombre by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Calculadora de IMC")

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso") }
        )

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Altura") }
        )

        Button(
            onClick = {

                val pesoNumero = peso.toFloatOrNull()
                val alturaNumero = altura.toFloatOrNull()

                if (
                    pesoNumero == null ||
                    alturaNumero == null ||
                    pesoNumero <= 0 ||
                    alturaNumero <= 0
                ) {
                    error = true
                } else {

                    error = false

                    val imc =
                        pesoNumero / (alturaNumero * alturaNumero)

                    val nombreCodificado =
                        URLEncoder.encode(
                            nombre,
                            StandardCharsets.UTF_8.toString()
                        )


                }
            }
        ) {
            Text("Calcular")
        }
    }
}