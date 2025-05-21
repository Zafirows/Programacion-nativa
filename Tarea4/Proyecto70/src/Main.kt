// Función que muestra la presentación del programa
fun presentacion() {
    println("Programa que permite cargar dos valores por teclado.") // Mensaje introductorio
    println("Efectua la suma de los valores")                      // Explica qué hace el programa
    println("Muestra el resultado de la suma")                    // Describe el resultado
    println("*******************************")                    // Línea decorativa
}

// Función que carga dos valores, los suma y muestra el resultado
fun cargarSumar() {
    print("Ingrese el primer valor:")        // Solicita el primer número
    val valor1 = readln().toInt()            // Lo lee y convierte a entero
    print("Ingrese el segundo valor:")       // Solicita el segundo número
    val valor2 = readln().toInt()            // Lo lee y convierte a entero
    val suma = valor1 + valor2               // Realiza la suma
    println("La suma de los dos valores es: $suma")  // Muestra el resultado
}

// Función que imprime un mensaje de despedida
fun finalizacion() {
    println("*******************************")                     // Línea decorativa
    println("Gracias por utilizar este programa")                // Mensaje final
}

// Función principal: punto de entrada del programa
fun main(parametro: Array<String>) {
    presentacion()   // Llama a la función de presentación
    cargarSumar()    // Llama a la función que suma los valores
    finalizacion()   // Llama a la función de despedida
}

