fun main(parametro: Array<String>) {
    // Se declara un arreglo de 10 elementos tipo Float (números decimales)
    val arreglo = FloatArray(10)

    // Se usa un bucle for para recorrer los índices del arreglo (0 hasta 9)
    for (i in arreglo.indices) {
        print("Ingrese elemento: ") // Pide al usuario un número
        arreglo[i] = readln().toFloat() // Lee el valor, lo convierte a Float y lo guarda en el arreglo
    }

    // Se imprime el listado completo del arreglo
    println("Listado completo del arreglo")
    for (elemento in arreglo)
        print("$elemento ") // Imprime cada valor separado por un espacio

    println() // Salto de línea para separar las salidas

    // Se cuenta cuántos elementos del arreglo son menores a 50
    val cant = arreglo.count { it < 50 }

    // Se imprime cuántos valores menores a 50 hay
    println("Cantidad de valores ingresados menores a 50: $cant")

    // Se verifica si *todos* los valores del arreglo son menores a 50
    if (arreglo.all { it < 50 })
        println("Todos los valores son menores a 50")
    else
        println("No todos los valores son menores a 50")
}
