package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.ui.theme.FirstAppTheme

// Clase principal de la aplicación, donde inicia la actividad
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita el modo de borde a borde (oculta la barra de estado/navegación en algunos dispositivos)
        enableEdgeToEdge()

        // setContent es el punto de entrada para definir la UI con Jetpack Compose
        setContent {
            FirstAppTheme { // Aplica el tema personalizado de la app
                // Scaffold proporciona una estructura básica de pantalla (como top bar, bottom bar, etc.)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Se llama a la función composable Greeting pasando el nombre y el padding que da Scaffold
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Función composable que muestra un saludo con fondo color cyan
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Surface es un contenedor que permite definir un fondo y diseño visual
    Surface(color = Color(0xFF80DEEA), modifier = Modifier.fillMaxSize()) {
        // Muestra un texto con padding de 24dp
        Text(
            text = "Hi, my name is $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}

// Función para previsualizar la UI en Android Studio sin correr la app
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Muestra el saludo con el nombre "Meghan" aplicando el tema de la app
    FirstAppTheme {
        Greeting("Meghan")
    }
}