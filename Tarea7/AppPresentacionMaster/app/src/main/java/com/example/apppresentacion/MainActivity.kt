package com.example.apppresentacion

// Importaciones necesarias para actividades, composables y elementos visuales
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apppresentacion.ui.theme.AppPresentacionTheme

// Clase principal de la app que extiende ComponentActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Extiende el contenido hasta los bordes de la pantalla

        // Define el contenido de la actividad usando Jetpack Compose
        setContent {
            // Aplica el tema personalizado
            AppPresentacionTheme {
                // Estructura base para la interfaz con compatibilidad para barras del sistema
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Llama a la función principal de la tarjeta de presentación
                    BusinessCardApp()
                }
            }
        }
    }
}

// Función principal composable que define la estructura de la tarjeta
@Composable
fun BusinessCardApp() {
    // Contenedor que ocupa toda la pantalla y tiene color de fondo oscuro
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF073042) // Color oscuro personalizado
    ) {
        // Organiza los elementos en columna, centrados
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileSection() // Muestra imagen, nombre y título
            Spacer(modifier = Modifier.height(32.dp)) // Espacio entre secciones
            ContactSection() // Muestra los datos de contacto
        }
    }
}

// Sección del perfil: imagen, nombre completo y título profesional
@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally // Centrado horizontal
    ) {
        // Imagen cargada desde recursos (debe estar en res/drawable)
        Image(
            painter = painterResource(id = R.drawable.tu_foto),
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(100.dp) // Tamaño de la imagen
        )
        // Nombre completo en texto grande y negrita
        Text(
            text = "Manuel Abraham Flores Ramirez",
            fontSize = 26.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        // Profesión o título con un color verde estilo Android
        Text(
            text = "Ing. Sistemas Computacionales",
            fontSize = 20.sp,
            color = Color(0xFF3ddc84) // Verde personalizado
        )
    }
}

// Sección con la información de contacto: teléfono, red social, email
@Composable
fun ContactSection() {
    // Column con padding horizontal
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        // Línea de contacto: Teléfono
        ContactInfoRow(icon = Icons.Default.Phone, contactText = "+52 833 844 0269")
        // Línea de contacto: Nombre de usuario o red social
        ContactInfoRow(icon = Icons.Default.Share, contactText = "@Manuel Abraham Flores Ramirez")
        // Línea de contacto: Correo electrónico
        ContactInfoRow(icon = Icons.Default.Email, contactText = "L20070511@cdmadero.tecnm.mx")
    }
}

// Composable reutilizable para mostrar un ícono y un texto en una fila
@Composable
fun ContactInfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, contactText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically, // Centra el ícono y texto verticalmente
        modifier = Modifier.padding(vertical = 8.dp) // Espacio entre filas
    ) {
        // Ícono representando el tipo de contacto
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84), // Mismo verde que el texto del título
            modifier = Modifier.size(24.dp)
        )
        // Espacio entre el ícono y el texto
        Spacer(modifier = Modifier.width(16.dp))
        // Texto del contacto
        Text(
            text = contactText,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

// Función para previsualizar la tarjeta de presentación en Android Studio
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardApp()
}
