fun main(parametro: Array<String>) {
    // Se declara un arreglo de 8 enteros con valores iniciales en 0
    val arreglo = IntArray(8)

    // Ciclo para llenar el arreglo con valores ingresados por el usuario
    for(i in arreglo.indices) {
        print("Ingrese elemento:")         // Solicita al usuario que ingrese un número
        arreglo[i] = readln().toInt()      // Lee la entrada, la convierte a entero y la guarda en el arreglo
    }

    // Se inicializan las variables para los cálculos
    var suma = 0             // Suma total de todos los elementos del arreglo
    var sumaMayor36 = 0      // Suma de elementos mayores a 36
    var cantMayor50 = 0      // Conteo de elementos mayores a 50

    // Se recorre el arreglo para calcular las sumas y contar elementos
    for(elemento in arreglo) {
        suma += elemento                     // Acumula el total de los elementos

        if (elemento > 30)
            sumaMayor36 += elemento         // Si el elemento es mayor a 30, se suma a 'sumaMayor36'

        if (elemento > 50)
            cantMayor50++                   // Si el elemento es mayor a 50, se incrementa el contador
    }

    // Se muestran los resultados en consola
    println("Valor acumulado del arreglo: $suma")
    println("Valor acumulado de los elementos mayores a 36: $sumaMayor36")
    println("Cantidad de elementos mayores a 50: $cantMayor50")
}
