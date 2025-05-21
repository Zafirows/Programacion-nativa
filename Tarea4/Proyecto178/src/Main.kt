fun main(args: Array<String>) {
    // Crea una lista de 100 elementos, cada uno con un número aleatorio entre 0 y 20 (inclusive)
    val lista1 = List(100, { ((Math.random() * 21)).toInt() })

    // Imprime la lista completa
    println(lista1)

    // Variables para contar cuántos elementos están en ciertos rangos
    var cant1 = 0  // Para valores entre 1 y 4
    var cant2 = 0  // Para valores entre 5 y 8
    var cant3 = 0  // Para valores entre 10 y 13

    // Recorre cada elemento de la lista y aumenta los contadores según el valor
    lista1.forEach {
        when (it) {
            in 1..4 -> cant1++
            in 5..8 -> cant2++
            in 10..13 -> cant3++
        }
    }

    // Imprime los resultados de los conteos
    println("Cantidad de valores comprendidos entre 1..4: $cant1")
    println("Cantidad de valores comprendidos entre 5..8: $cant2")

    // ⚠️ ERROR: aquí debería imprimirse `cant3`, no `cant1`
    println("Cantidad de valores comprendidos entre 10..13: $cant1")  // ← esto está mal

    // CORREGIDO:
    // println("Cantidad de valores comprendidos entre 10..13: $cant3")

    // Verifica si en la lista hay algún 20
    if (lista1.contains(20))
        println("La lista contiene el 20")
    else
        println("La lista no contiene el 20")
}
