// Operaciones con conjuntos mutables (MutableSet)
fun main(args: Array<String>) {
    val conjunto1: MutableSet<Int> = mutableSetOf(2, 7, 20, 150, 3)

    println("Listado completo del conjunto")
    for (elemento in conjunto1)
        print("$elemento ")
    println()

    println("Cantidad de elementos del conjunto: ${conjunto1.size}")

    conjunto1.add(500)
    println("Después de agregar el 500:")
    println(conjunto1)

    conjunto1.add(500)
    println("Después de intentar agregar el 500 nuevamente (no se repite):")
    println(conjunto1)

    if (500 in conjunto1)
        println("El 500 está almacenado en el conjunto")
    else
        println("El 500 no está almacenado en el conjunto")

    println("Eliminamos el elemento 500 del conjunto")
    conjunto1.remove(500)

    if (500 in conjunto1)
        println("El 500 está almacenado en el conjunto")
    else
        println("El 500 no está almacenado en el conjunto")

    val cant = conjunto1.count { it >= 10 }
    println("Cantidad de elementos con valores superiores o igual a 10: $cant")
}