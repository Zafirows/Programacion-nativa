fun main(parametro: Array<String>) {
    // Contadores para diferentes tipos de valores
    var cant1 = 0  // Contador para la cantidad de ceros ingresados
    var cant2 = 0  // Contador para la cantidad de 1, 5 o 10 ingresados

    // Repite el ingreso 10 veces
    for(i in 1..10) {
        // Pide al usuario que ingrese un valor entero
        print("Ingrese un valor entero:")
        val valor = readln().toInt()

        // Evalúa el valor ingresado usando 'when'
        when (valor) {
            0 -> cant1++              // Si es 0, incrementa cant1
            1, 5, 10 -> cant2++       // Si es 1, 5 o 10, incrementa cant2
        }
    }

    // Imprime los resultados
    println("Cantidad de números 0 ingresados: $cant1")
    println("Cantidad de números 1, 5 o 10 ingresados: $cant2")
}
