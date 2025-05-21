// Función para cargar un arreglo con valores ingresados por el usuario
fun cargar(): IntArray {
    print("¿Cuántos elementos tendrá el arreglo?: ")
    val cantidad = readln().toInt()                // Se lee la cantidad de elementos
    val arreglo = IntArray(cantidad)               // Se crea el arreglo con esa cantidad

    for (i in arreglo.indices) {
        print("Ingrese elemento: ")
        arreglo[i] = readln().toInt()              // Se llena el arreglo con valores ingresados
    }
    return arreglo                                  // Se devuelve el arreglo completo
}

// Función para imprimir todos los elementos del arreglo
fun imprimir(arreglo: IntArray) {
    println("Listado completo del arreglo:")
    for (elemento in arreglo)
        println(elemento)                          // Imprime cada elemento uno por uno
}

// Función para sumar los elementos del arreglo
fun sumar(arreglo: IntArray): Int {
    var suma = 0
    for (elemento in arreglo)
        suma += elemento                           // Acumula cada número en la variable 'suma'
    return suma                                     // Devuelve la suma total
}

// Función principal que une todo
fun main(parametro: Array<String>) {
    val arreglo = cargar()                                             // Carga el arreglo con datos del usuario
    imprimir(arreglo)                                                 // Imprime el contenido del arreglo
    println("La suma de todos sus elementos es: ${sumar(arreglo)}")   // Muestra la suma de los elementos
}
