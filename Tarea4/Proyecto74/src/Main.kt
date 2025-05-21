// Función que muestra un mensaje enmarcado entre líneas de asteriscos
fun mostrarMensaje(mensaje: String) {
    println("*************************************************") // Línea superior decorativa
    println(mensaje)                                        // Muestra el mensaje recibido como parámetro
    println("*************************************************") // Línea inferior decorativa
}

// Función que solicita dos números, los suma y muestra el resultado
fun cargarSumar() {
    print("Ingrese el primer valor:")       // Pide al usuario el primer número
    val valor1 = readln().toInt()           // Lee y convierte a entero el primer valor
    print("Ingrese el segundo valor:")      // Pide al usuario el segundo número
    val valor2 = readln().toInt()           // Lee y convierte a entero el segundo valor
    val suma = valor1 + valor2              // Realiza la suma de los dos valores
    println("La suma de los dos valores es: $suma")  // Muestra el resultado
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Muestra un mensaje introductorio usando la función mostrarMensaje
    mostrarMensaje("El programa calcula la suma de dos valores ingresados por teclado.")

    // Llama a la función que pide dos números y muestra su suma
    cargarSumar()

    // Muestra un mensaje de despedida usando la función mostrarMensaje
    mostrarMensaje("Gracias por utilizar este programa")
}
