fun main(parametro: Array<String>) {
    var suma = 0 // Variable acumuladora para sumar los últimos 5 valores ingresados

    for(i in 1..10) { // Se repite el proceso 10 veces
        print("Ingrese un valor entero:")
        val valor = readln().toInt() // Se lee un número entero desde el teclado

        if (i > 5) // Solo si estamos en las últimas 5 iteraciones (i = 6 a 10)
            suma += valor // Se suma ese valor a la variable 'suma'
    }

    // Al terminar el bucle, se imprime la suma de los últimos 5 valores ingresados
    print("La suma de los últimos 5 valores es: $suma");
}
