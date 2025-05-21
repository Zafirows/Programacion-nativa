fun main(parametro: Array<String>) {
    var cant1 = 0    // Contador de piezas con peso > 10.2
    var cant2 = 0    // Contador de piezas aptas (entre 9.8 y 10.2 inclusive)
    var cant3 = 0    // Contador de piezas con peso < 9.8

    do {
        print("Ingrese el peso de la pieza (0 para finalizar):")
        val peso = readln().toDouble()  // Se lee el peso ingresado por el usuario

        // Clasificamos la pieza según el peso
        if (peso > 10.2)
            cant1++              // Piezas con sobrepeso
        else
            if (peso >= 9.8)
                cant2++          // Piezas aptas
            else
                if (peso > 0)
                    cant3++      // Piezas con bajo peso (excluyendo el 0)

    } while(peso != 0.0)  // El ciclo continúa hasta que el peso sea 0

    // Mostramos los resultados
    println("Piezas aptas: $cant2")
    println("Piezas con un peso superior a 10.2: $cant1")
    println("Piezas con un peso inferior a 9.8: $cant3")

    // Calculamos el total de piezas procesadas (excluyendo el 0)
    val suma = cant1 + cant2 + cant3
    println("Cantidad total de piezas procesadas: $suma")
}
