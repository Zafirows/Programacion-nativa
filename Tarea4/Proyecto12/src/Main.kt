fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese el primer valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'valor1'
    val valor1 = readln().toInt()

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese el segundo valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'valor2'
    val valor2 = readln().toInt()

    // Compara si 'valor1' es menor que 'valor2'
    if (valor1 < valor2) {
        // Si es verdadero, calcula la suma y la resta
        val suma = valor1 + valor2
        val resta = valor1 - valor2
        // Imprime la suma y la resta de los dos valores
        println("La suma de los dos valores es: $suma")
        println("La resta de los dos valores es: $resta")
    } else {
        // Si no es menor, calcula el producto y la división
        val producto = valor1 * valor2
        val division = valor1 / valor2  // Este cálculo puede causar una excepción si 'valor2' es 0
        // Imprime el producto y la división de los dos valores
        println("El producto de los dos valores es: $producto")
        println("La división de los dos valores es: $division")
    }
}
