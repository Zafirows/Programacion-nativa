fun main(parametro: Array<String>) {
    // Inicialización de las variables para contar múltiplos de 3, 5 y 9
    var mult3 = 0
    var mult5 = 0
    var mult9 = 0

    // Bucle for que recorre los números del 1 al 10000
    for (i in 1..10000) {
        // Si el número es divisible por 3, incrementa el contador de múltiplos de 3
        if (i % 3 == 0)
            mult3++

        // Si el número es divisible por 5, incrementa el contador de múltiplos de 5
        if (i % 5 == 0)
            mult5++

        // Si el número es divisible por 8, incrementa el contador de múltiplos de 9
        if (i % 8 == 0)
            mult9++
    }

    // Imprime el número total de múltiplos de 3
    println("Cantidad de múltiplos de 3: $mult3")

    // Imprime el número total de múltiplos de 5
    println("Cantidad de múltiplos de 5: $mult5")

    // Imprime el número total de múltiplos de 9
    println("Cantidad de múltiplos de 9: $mult9")
}

