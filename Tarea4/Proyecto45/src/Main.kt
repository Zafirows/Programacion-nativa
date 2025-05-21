fun main(parametro: Array<String>)  {
    var suma = 0         // Variable acumuladora para la suma

    do {
        print("Ingrese un valor (finalizar con 9999):")
        val valor = readln().toInt()   // Lee el valor ingresado

        // Si el valor no es 9999, se acumula en 'suma'
        if (valor != 9999)
            suma += valor

    } while (valor != 9999)   // El ciclo continúa mientras no se ingrese 9999

    // Muestra el total acumulado
    println("El valor acumulado es $suma")

    // Determina el signo del total acumulado
    if (suma == 0)
        println("El valor acumulado es cero.")
    else
        if (suma > 0)
            println("El valor acumulado es positivo.")
        else
            println("El valor acumulado es negativo")
}
