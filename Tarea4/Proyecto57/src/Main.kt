fun main(parametro: Array<String>) {
    var cant1 = 0  // Contador para puntos en el 1er cuadrante (x>0, y>0)
    var cant2 = 0  // Contador para puntos en el 2do cuadrante (x<0, y>0)
    var cant3 = 0  // Contador para puntos en el 3er cuadrante (x<0, y<0)
    var cant4 = 0  // Contador para puntos en el 4to cuadrante (x>0, y<0)

    // Se solicita cuántos puntos se van a ingresar
    print("Cantidad de puntos a ingresar:")
    val cantidad = readln().toInt()

    // Se ejecuta un ciclo por cada punto
    for(i in 1..cantidad) {
        // Se ingresan las coordenadas del punto
        print("Ingrese coordenada x:")
        val x = readln().toInt()
        print("Ingrese coordenada y:")
        val y = readln().toInt()

        // Clasificación del punto según su cuadrante
        if (x > 0 && y > 0)
            cant1++
        else if (x < 0 && y > 0)
            cant2++
        else if (x < 0 && y < 0)
            cant3++
        else if (x > 0 && y < 0)
            cant4++
    }

    // Mostrar los resultados
    println("Cantidad de puntos en el primer cuadrante: $cant1")
    println("Cantidad de puntos en el segundo cuadrante: $cant2")
    println("Cantidad de puntos en el tercer cuadrante: $cant3")
    println("Cantidad de puntos en el cuarto cuadrante: $cant4")
}