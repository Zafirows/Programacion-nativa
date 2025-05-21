fun main(parametro: Array<String>) {
    // Se declara una constante entera llamada 'valor1' y se le asigna el valor 100
    val valor1: Int = 100

    // Se declara una constante entera llamada 'valor2' y se le asigna el valor 400
    val valor2: Int = 400

    // Se declara una variable llamada 'resultado' y se inicializa con la suma de valor1 y valor2
    var resultado: Int = valor1 + valor2

    // Se imprime el resultado de la suma usando interpolación de cadenas
    println("La suma de $valor1 + $valor2 es $resultado")

    // Ahora se actualiza la variable 'resultado' con el producto de valor1 y valor2
    resultado = valor1 * valor2

    // Se imprime el resultado de la multiplicación
    println("El producto de $valor1 * $valor2 es $resultado")
}
