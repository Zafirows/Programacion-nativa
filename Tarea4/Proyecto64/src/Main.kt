fun main(parametro: Array<String>) {
    // Se declara una variable para acumular la suma de los valores mayores de cada grupo de 3
    var suma = 0

    // Se repite el bloque 5 veces, es decir, se ingresarán 5 grupos de 3 valores
    for(i in 1..5) {
        // Solicita al usuario que ingrese el primer valor
        print("Ingrese primer valor:")
        val valor1 = readln().toInt()

        // Solicita el segundo valor
        print("Ingrese segundo valor:")
        val valor2 = readln().toInt()

        // Solicita el tercer valor
        print("Ingrese tercer valor:")
        val valor3 = readln().toInt()

        // Determina cuál de los tres valores es el mayor usando la expresión 'when'
        // y lo suma a la variable 'suma'
        suma += when {
            valor1 > valor2 && valor1 > valor3 -> valor1 // Si valor1 es mayor que los otros dos
            valor2 > valor3 -> valor2 // Si valor2 es mayor que valor3 (y menor que valor1)
            else -> valor3 // En cualquier otro caso, valor3 es el mayor
        }
    }

    // Imprime el resultado acumulado de los valores mayores de cada grupo de 3
    println("El valor acumulado de los mayores de cada lista de 3 valores es : $suma")
}
