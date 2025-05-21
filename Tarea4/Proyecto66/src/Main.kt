fun main(parameto: Array<String>) {
    // Solicita al usuario que ingrese un número entero entre 1 y 5
    print("Ingrese un valor entero entre 1 y 5:")

    // Lee la entrada del usuario como texto y la convierte a número entero
    val valor = readln().toInt()

    // Utiliza una estructura 'when' para comparar el valor ingresado
    when (valor) {
        1 -> print("uno")       // Si el valor es 1, imprime "uno"
        2 -> print("dos")       // Si el valor es 2, imprime "dos"
        3 -> print("tres")      // Si el valor es 3, imprime "tres"
        4 -> print("cuatro")    // Si el valor es 4, imprime "cuatro"
        5 -> print("cinco")     // Si el valor es 5, imprime "cinco"
        else -> print("valor fuera de rango") // Si el valor no está entre 1 y 5
    }
}
