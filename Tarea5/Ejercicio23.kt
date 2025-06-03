//CAPITULO 14 -Excepciones
fun example() {
    try {
        // Aquí va el código que puede lanzar una excepción
        // Por ejemplo, acceso a archivos, operaciones que pueden fallar, etc.
    } catch (e: Exception) {
        // Este bloque se ejecuta si ocurre cualquier excepción del tipo Exception
        // 'e.message' contiene el mensaje de error de la excepción
        println("Error: ${e.message}")
    } finally {
        // Este bloque se ejecuta siempre, ocurra o no una excepción
        // Se usa para liberar recursos o hacer limpieza necesaria
        println("Cleanup")
    }
}
