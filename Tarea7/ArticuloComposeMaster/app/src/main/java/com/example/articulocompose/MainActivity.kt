package com.example.articulocompose

// Importaciones necesarias para Jetpack Compose y Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articulocompose.ui.theme.ArticuloComposeTheme

// Actividad principal que se ejecuta al iniciar la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita que el contenido pueda ir hasta los bordes de la pantalla
        setContent {
            // Aplica el tema personalizado de la app
            ArticuloComposeTheme {
                // Contenedor de superficie con el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Rellena toda la pantalla
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama al componente principal de la app
                    ArticuloComposeApp()
                }
            }
        }
    }
}

// Función principal que compone el contenido del artículo
@Composable
fun ArticuloComposeApp() {
    ArticleCard(
        title = stringResource(R.string.title_jetpack_compose_tutorial), // Título desde strings.xml
        shortDescription = stringResource(R.string.compose_short_desc), // Descripción corta
        longDescription = stringResource(R.string.compose_long_desc), // Descripción larga
        imagePainter = painterResource(R.drawable.bg_compose_background) // Imagen desde drawable
    )
}

// Composable que representa una tarjeta de artículo con imagen y texto
@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) { // Coloca los elementos en vertical
        Image(painter = imagePainter, contentDescription = null) // Imagen sin descripción accesible
        Text(
            text = title,
            modifier = Modifier.padding(16.dp), // Espaciado alrededor
            fontSize = 24.sp // Tamaño del texto del título
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp), // Margen horizontal
            textAlign = TextAlign.Justify // Justifica el texto
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp), // Margen completo
            textAlign = TextAlign.Justify // Justifica el texto
        )
    }
}

// Vista previa en Android Studio del diseño sin necesidad de ejecutar la app
@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    ArticuloComposeTheme {
        ArticuloComposeApp() // Muestra el diseño del artículo
    }
}
