// Función para calcular y mostrar el perímetro de un cuadrado
fun mostrarPerimetro(lado: Int) {
    val perimetro = lado * 4  // El perímetro de un cuadrado es 4 veces el lado
    println("El perímetro es $perimetro")  // Muestra el resultado
}

// Función para calcular y mostrar la superficie (área) de un cuadrado
fun mostrarSuperficie(lado: Int) {
    val superficie = lado * lado  // La superficie de un cuadrado es lado al cuadrado
    println("La superficie es $superficie")  // Muestra el resultado
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Pide al usuario que ingrese el valor del lado del cuadrado
    print("Ingrese el valor del lado de un cuadrado:")
    val la = readln().toInt()

    // Pregunta qué desea calcular: perímetro o superficie
    print("Quiere calcular el perimetro o la superficie [ingresar texto: perimetro/superficie]")
    var respuesta = readln()

    // Según la respuesta del usuario, se llama a la función correspondiente
    when (respuesta) {
        "perimetro" -> mostrarPerimetro(la)      // Llama a la función de perímetro
        "superficie" -> mostrarSuperficie(la)    // Llama a la función de superficie
    }
}
