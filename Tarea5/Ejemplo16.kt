//CAPITULO 8 -Coutines
// Importa el paquete necesario para usar corrutinas
/*import kotlinx.coroutines.*

// Función principal que se ejecuta en un contexto bloqueante de corrutina
fun main() = runBlocking {
    // Inicia una nueva corrutina en paralelo dentro del bloque runBlocking
    launch {
        // Suspende la ejecución de esta corrutina durante 1 segundo (1000 milisegundos)
        delay(1000L)
        // Después de 1 segundo, imprime "World!"
        println("World!")
    }
    // Mientras la corrutina lanzada está en espera, esto se ejecuta inmediatamente
    println("Hello,")
    // runBlocking esperará automáticamente a que todas las corrutinas hijas finalicen
}
*/