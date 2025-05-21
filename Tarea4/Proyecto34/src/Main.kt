fun main(parametro: Array<String>) {
    print("Cuantas piezas procesará:")
    val n = readln().toInt()         // El usuario indica cuántas piezas se van a procesar

    var x = 1                         // Contador
    var cantidad = 0                 // Contador de piezas aptas

    while (x <= n) {                 // Bucle que se repite n veces
        print("Ingrese la medida de la pieza:")
        val largo = readln().toDouble()   // El usuario ingresa la medida de la pieza (decimal)

        if (largo >= 1.20 && largo <= 1.30) // Si la medida está en el rango aceptable
            cantidad = cantidad + 1        // Se incrementa el contador de piezas aptas

        x = x + 1                     // Incrementa el contador de iteraciones
    }

    print("La cantidad de piezas aptas son: $cantidad")
}
