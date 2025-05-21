// Función que carga dos valores por teclado, los suma y muestra el resultado
fun cargarSuma() {
    print("Ingrese el primer valor:")         // Solicita el primer número al usuario
    val valor1 = readln().toInt()             // Lee el primer valor y lo convierte a entero
    print("Ingrese el segundo valor:")        // Solicita el segundo número
    val valor2 = readln().toInt()             // Lee el segundo valor y lo convierte a entero
    val suma = valor1 + valor2                // Realiza la suma de los dos valores
    println("La suma de los dos valores es: $suma") // Muestra el resultado de la suma
}

// Función que imprime una línea de separación decorativa
fun separacion() {
    println("*******************************") // Imprime una línea para separar visualmente las operaciones
}

// Función principal donde inicia la ejecución del programa
fun main(parametro: Array<String>) {
    // Bucle que repite 5 veces el ingreso y suma de valores
    for (i in 1..5) {
        cargarSuma()    // Llama a la función que suma dos valores
        separacion()    // Llama a la función que imprime la línea de separación
    }
}
