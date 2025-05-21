fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'valor1'
    val valor1 = readln().toInt()

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'valor2'
    val valor2 = readln().toInt()

    // Utiliza una expresión 'if' para determinar cuál de los dos valores es mayor
    val mayor = if (valor1 > valor2) valor1 else valor2

    // Imprime el valor mayor entre 'valor1' y 'valor2'
    println("El mayor entre $valor1 y $valor2 es $mayor")
}
