// Uso de listas inmutables en Kotlin
fun main(args: Array<String>) {
    val lista1: List<String> = listOf(
        "lunes", "martes", "miércoles", "jueves",
        "viernes", "sábado", "domingo"
    )

    println("Imprimir la lista completa")
    println(lista1)

    println("Imprimir el primer elemento de la lista")
    println(lista1[0])
    println(lista1.first())

    println("Imprimir el último elemento de la lista")
    println(lista1.last())
    println(lista1[lista1.size - 1])

    println("Imprimir la cantidad de elementos de la lista")
    println(lista1.size)

    println("Recorrer la lista completa con un for")
    for (elemento in lista1)
        print("$elemento ")
    println()

    println("Imprimir el elemento y su posición")
    for (posicion in lista1.indices)
        print("[$posicion]${lista1[posicion]} ")
}