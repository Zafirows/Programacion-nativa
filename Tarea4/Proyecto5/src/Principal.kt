fun main(argumento: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    // Lee la entrada del usuario, la convierte a entero y la guarda en 'valor1'
    val valor1 = readln().toInt()

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    // Lee la entrada del usuario, la convierte a entero y la guarda en 'valor2'
    val valor2 = readln().toInt()

    // Se calcula la suma de los dos valores ingresados
    val suma = valor1 + valor2
    // Se imprime el resultado de la suma
    println("La suma de $valor1 y $valor2 es $suma")

    // Se calcula el producto de los dos valores
    val producto = valor1 * valor2
    // Se imprime el resultado del producto
    println("El producto de $valor1 y $valor2 es $producto")
}
