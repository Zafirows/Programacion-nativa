// Paquete principal de la app
package com.example.lemonade

// Importaciones necesarias para el funcionamiento de la app con Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita contenido detrás de barras del sistema
        super.onCreate(savedInstanceState)
        // Establece el contenido de la UI con Jetpack Compose
        setContent {
            LemonadeTheme {
                LemonadeApp() // Llama a la función principal de la UI
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {

    // Estado que controla el paso actual del flujo de la limonada
    var currentStep by remember { mutableStateOf(1) }

    // Contador de exprimidas necesarias (entre 2 y 4 aleatorio)
    var squeezeCount by remember { mutableStateOf(0) }

    // Scaffold para tener una barra superior y contenido principal
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        // Contenedor principal con Surface
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            // Flujo del proceso de hacer limonada
            when (currentStep) {
                1 -> {
                    // Paso 1: seleccionar un limón del árbol
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_select,
                        drawableResourceId = R.drawable.lemon_tree,
                        contentDescriptionResourceId = R.string.lemon_tree_content_description,
                        onImageClick = {
                            currentStep = 2 // Avanza al paso 2
                            squeezeCount = (2..4).random() // Define cuántas veces hay que exprimir
                        }
                    )
                }
                2 -> {
                    // Paso 2: exprimir el limón
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_squeeze,
                        drawableResourceId = R.drawable.lemon_squeeze,
                        contentDescriptionResourceId = R.string.lemon_content_description,
                        onImageClick = {
                            squeezeCount-- // Resta una exprimida
                            if (squeezeCount == 0) {
                                currentStep = 3 // Cuando se acaba, pasa al paso 3
                            }
                        }
                    )
                }
                3 -> {
                    // Paso 3: beber la limonada
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_drink,
                        drawableResourceId = R.drawable.lemon_drink,
                        contentDescriptionResourceId = R.string.lemonade_content_description,
                        onImageClick = {
                            currentStep = 4 // Avanza al paso 4
                        }
                    )
                }
                4 -> {
                    // Paso 4: reiniciar el proceso
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_empty_glass,
                        drawableResourceId = R.drawable.lemon_restart,
                        contentDescriptionResourceId = R.string.empty_glass_content_description,
                        onImageClick = {
                            currentStep = 1 // Vuelve al paso 1
                        }
                    )
                }
            }
        }
    }
}

// Función que muestra el texto y la imagen (con botón) en cada paso
@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int, // ID del texto a mostrar
    drawableResourceId: Int, // ID de la imagen a mostrar
    contentDescriptionResourceId: Int, // ID de la descripción para accesibilidad
    onImageClick: () -> Unit, // Acción a ejecutar al pulsar la imagen
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Botón con imagen dentro
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }

            // Espaciado entre imagen y texto
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))

            // Texto descriptivo debajo de la imagen
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

// Vista previa de la app en el editor de Android Studio
@Preview
@Composable
fun LemonPreview() {
    LemonadeTheme(){
        LemonadeApp()
    }
}
