fun main(parametro: Array<String>) {
    print("Cuantas alturas ingresará?:")
    val n = readln().toInt()  // Cantidad de personas

    var x = 1                 // Contador
    var suma = 0.0            // Acumulador para la suma de alturas

    while (x <= n) {          // Se repite n veces
        print("Ingrese la altura de la persona (Ej: 1.76) :")
        val altura = readln().toDouble()  // Leer altura como número decimal
        suma = suma + altura              // Acumular la altura
        x = x + 1                         // Avanzar al siguiente ingreso
    }

    val promedio = suma / n               // Calcular el promedio
    println("Altura promedio: $promedio") // Mostrar resultado
}
