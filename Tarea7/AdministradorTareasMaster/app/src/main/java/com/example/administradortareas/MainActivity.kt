package com.example.administradortareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.administradortareas.ui.theme.AdministradorTareasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdministradorTareasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama al componente composable principal
                    TaskCompletedScreen()
                }
            }
        }
    }
}

// Función composable que muestra la pantalla de tareas completadas
@Composable
fun TaskCompletedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(), // Llena toda la pantalla
        verticalArrangement = Arrangement.Center, // Centrado vertical
        horizontalAlignment = Alignment.CenterHorizontally // Centrado horizontal
    ) {
        // Imagen representando que la tarea está completada
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null // No se requiere descripción si es decorativa
        )
        // Primer texto con estilo en negrita y padding
        Text(
            text = stringResource(R.string.all_task_completed),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        // Segundo texto con tamaño de fuente personalizado
        Text(
            text = stringResource(R.string.nice_work),
            fontSize = 16.sp
        )
    }
}
// Vista previa de la pantalla para el modo diseño
@Preview(showBackground = true)
@Composable
fun TaskCompletedPreview() {
    AdministradorTareasTheme {
        TaskCompletedScreen()
    }
}
