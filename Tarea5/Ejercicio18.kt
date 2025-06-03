//CAPITULO 9 -Declaraciones condicionales
fun main() {
    val str = "Hello!"

    // Uso de 'when' sin argumento para evaluar condiciones booleanas
    when {
        str.length == 0 -> print("Empty string!")  // Si la cadena está vacía
        str.length > 5 -> print("Long string!")    // Si la cadena tiene más de 5 caracteres
        else -> print("Short string!")              // Si no se cumple ninguna condición anterior
    }
}
