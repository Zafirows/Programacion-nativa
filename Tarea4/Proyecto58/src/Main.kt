fun main(parametro: Array<String>) {
    var negativos = 0      // Contador para números negativos
    var positivos = 0      // Contador para números positivos
    var mult15 = 0         // Contador para múltiplos de 15
    var sumapares = 0      // Acumulador para sumar números pares

    // Bucle que se ejecuta 10 veces para ingresar 10 valores
    for(i in 1..10) {
        print("Ingrese valor:")
        val valor = readln().toInt()  // Se lee el número ingresado por el usuario

        // Se clasifica el número como negativo o positivo
        if (valor < 0)
            negativos++
        else
            if (valor > 0)
                positivos++

        // Se verifica si es múltiplo de 15
        if (valor % 15 == 0)
            mult15++

        // Se verifica si es par y se suma en caso afirmativo
        if (valor % 2 == 0)
            sumapares += valor
    }

    // Resultados finales
    println("Cantidad de valores negativos: $negativos")
    println("Cantidad de valores positivos: $positivos")
    println("Cantidad de valores múltiplos de 15: $mult15")
    println("Suma de los valores pares: $sumapares")
}
