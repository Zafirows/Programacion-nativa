fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un valor entero
    print("Ingrese un valor entero: ")
    // Lee la entrada, la convierte a entero y la guarda en 'valor'
    val valor = readln().toInt()

    // Se evalúa si el número ingresado es par o impar
    val resultado = if (valor % 2 == 0) {
        // Si el valor es par, se calcula su cuadrado
        println("Cuadrado:")
        valor * valor
    } else {
        // Si el valor es impar, se calcula su cubo
        println("Cubo:")
        valor * valor * valor
    }

    // Imprime el resultado, que será el cuadrado o cubo dependiendo del caso
    println(resultado)
}

