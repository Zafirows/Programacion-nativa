fun main(parametro: Array<String>) {
    var x = 1              // Contador inicializado en 1
    var suma = 0           // Acumulador para la suma de los valores

    while (x <= 10) {      // Se repite 10 veces
        print("Ingrese un valor:")
        val valor = readln().toInt()   // Lee un valor ingresado por el usuario y lo convierte a entero
        suma = suma + valor            // Se acumula el valor ingresado
        x = x + 1                      // Se incrementa el contador
    }

    println("La suma de los 10 valores ingresados es $suma")

    val promedio = suma / 10           // Calcula el promedio (división entera)
    println("El promedio es $promedio")
}
