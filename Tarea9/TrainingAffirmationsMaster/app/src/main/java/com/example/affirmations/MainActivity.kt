// Declaración del paquete
package com.example.affirmations

// Imports necesarios para Android, Jetpack Compose y recursos
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

// Clase principal de la aplicación (punto de entrada)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la UI usando Jetpack Compose
        setContent {
            // Aplica el tema definido en ui/theme
            AffirmationsTheme {
                // Crea un fondo que cubre toda la pantalla
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama a la función principal de la UI
                    AffirmationsApp()
                }
            }
        }
    }
}

// Función principal de la UI
@Composable
fun AffirmationsApp() {
    val layoutDirection = LocalLayoutDirection.current
    // Crea un contenedor principal con relleno para las barras de estado
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        // Muestra la lista de afirmaciones cargadas desde el Datasource
        AffirmationList(
            affirmationList = Datasource().loadAffirmations()
        )
    }
}

// Muestra una lista vertical (LazyColumn) de tarjetas de afirmación
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        // Recorre la lista de afirmaciones y crea una tarjeta para cada una
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp) // Espaciado entre tarjetas
            )
        }
    }
}

// Muestra una tarjeta con imagen y texto de una afirmación
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            // Muestra la imagen asociada a la afirmación
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp), // Altura fija para la imagen
                contentScale = ContentScale.Crop // Recorta para llenar el espacio
            )
            // Muestra el texto de la afirmación
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

// Vista previa en el editor de Android Studio
@Preview(showBackground = true)
@Composable
private fun AffirmationCardPreview() {
    AffirmationsTheme {
        // Muestra una tarjeta de ejemplo con un recurso simulado
        AffirmationCard(
            affirmation = Affirmation(R.string.affirmation1, R.drawable.image1)
        )
    }
}
