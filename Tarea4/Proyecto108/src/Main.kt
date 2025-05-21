// Función para cargar un arreglo con datos del usuario
fun cargar(): IntArray {
    print("Cuántos elementos tendrá el arreglo: ")
    val cantidad = readln().toInt()                  // Se pide la cantidad de elementos
    val arreglo = IntArray(cantidad)                 // Se crea el arreglo con ese tamaño

    // Se llena el arreglo con valores del usuario
    for (i in arreglo.indices) {
        print("Ingrese elemento: ")
        arreglo[i] = readln().toInt()
    }
    return arreglo                                    // Se devuelve el arreglo lleno
}

// Función para imprimir todos los elementos del arreglo
fun imprimir(arreglo: IntArray) {
    println("Listado completo del arreglo:")
    for (elemento in arreglo)
        println(elemento)
}

// Función para encontrar el elemento mayor del arreglo
fun mayor(arreglo: IntArray): Int {
    var may = arreglo[0]                              // Se toma el primer elemento como el mayor inicial
    for (elemento in arreglo)
        if (elemento > may)
            may = elemento                            // Se actualiza si se encuentra un número mayor
    return may
}

// Función para saber si un número aparece más de una vez
fun repite(arreglo: IntArray, buscar: Int): Boolean {
    var cant = 0
    for (elemento in arreglo)
        if (elemento == buscar)
            cant++                                    // Se cuenta cuántas veces aparece el valor

    return cant > 1                                   // Devuelve true si aparece más de una vez
}

// Función principal
fun main(parametro: Array<String>) {
    val arreglo = cargar()                            // Carga el arreglo desde consola
    imprimir(arreglo)                                 // Muestra todos los elementos
    val mayorElemento = mayor(arreglo)                // Busca el mayor
    println("El elemento mayor es $mayorElemento")    // Imprime el mayor

    // Verifica si el mayor se repite
    if (repite(arreglo, mayorElemento))
        println("Se repite el mayor en el arreglo")
    else
        println("No se repite el mayor en el arreglo")
}
