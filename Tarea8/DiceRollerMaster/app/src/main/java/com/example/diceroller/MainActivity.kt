// Paquete principal de la app
package com.example.diceroller

// Importaciones necesarias para la actividad y UI con Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la UI usando Jetpack Compose
        setContent {
            // Aplica el tema de la app
            DiceRollerTheme {
                // Surface actúa como contenedor base con fondo temático
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema
                ) {
                    // Llama al componente principal de la app
                    DiceRollerApp()
                }
            }
        }
    }
}

// Anotación para mostrar vista previa en el editor de Android Studio
@Preview
@Composable
fun DiceRollerApp() {
    // Llama a la función composable que contiene la lógica de dado y botón
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el tamaño del contenedor
            .wrapContentSize(Alignment.Center) // Centra el contenido
    )
}

// Función composable que muestra el dado y un botón para tirarlo
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // Variable de estado para almacenar el resultado actual del dado
    var result by remember { mutableStateOf(1) }

    // Selecciona la imagen correspondiente al valor del dado
    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6 // Para el caso de valor 6
    }

    // Organiza los elementos en una columna, centrados horizontalmente
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // Muestra la imagen del dado según el valor actual
        Image(
            painter = painterResource(imageResource), // Imagen del recurso
            contentDescription = result.toString() // Descripción para accesibilidad
        )

        // Botón que, al hacer clic, genera un número aleatorio del 1 al 6
        Button(
            onClick = { result = (1..6).random() }, // Al hacer clic, cambia el valor del dado
        ) {
            // Texto del botón (por ejemplo: "Roll")
            Text(
                text = stringResource(R.string.roll), // Usa el recurso de string definido
                fontSize = 24.sp // Tamaño de fuente
            )
        }
    }
}
