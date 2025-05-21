// Se define una clase llamada Punto con dos propiedades: x e y (las coordenadas)
class Punto(val x: Int, val y: Int) {

    // Esta función determina en qué cuadrante se encuentra el punto (x, y)
    fun retornarCuadrante() = when {
        // Si x > 0 y y > 0, está en el primer cuadrante
        x > 0 && y > 0 -> "Primer cuadrante"

        // Si x < 0 y y > 0, está en el segundo cuadrante
        x < 0 && y > 0 -> "Segundo cuadrante"

        // Si x < 0 y y < 0, está en el tercer cuadrante
        x < 0 && y < 0 -> "Tercer cuadrante"

        // Si x > 0 y y < 0, está en el cuarto cuadrante
        x > 0 && y < 0 -> "Cuarto cuadrante"

        // Si no entra en ningún caso anterior, entonces está sobre un eje
        else -> "Un eje"
    }
}
// Función principal del programa
fun main(parametro: Array<String>) {

    // Se crean 5 objetos de tipo Punto con distintas coordenadas
    val punto1 = Punto(12, 3)     // x > 0, y > 0 → Primer cuadrante
    println("La coordenada ${punto1.x}, ${punto1.y} se encuentra en ${punto1.retornarCuadrante()}")

    val punto2 = Punto(-4, 3)     // x < 0, y > 0 → Segundo cuadrante
    println("La coordenada ${punto2.x}, ${punto2.y} se encuentra en ${punto2.retornarCuadrante()}")

    val punto3 = Punto(-2, -2)    // x < 0, y < 0 → Tercer cuadrante
    println("La coordenada ${punto3.x}, ${punto3.y} se encuentra en ${punto3.retornarCuadrante()}")

    val punto4 = Punto(12, -5)    // x > 0, y < 0 → Cuarto cuadrante
    println("La coordenada ${punto4.x}, ${punto4.y} se encuentra en ${punto4.retornarCuadrante()}")

    val punto5 = Punto(0, -5)     // x = 0 → está sobre un eje
    println("La coordenada ${punto5.x}, ${punto5.y} se encuentra en ${punto5.retornarCuadrante()}")
}
