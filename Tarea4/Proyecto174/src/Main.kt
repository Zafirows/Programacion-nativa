// Crear una lista con entrada por teclado
fun cargar(): Int {
    print("Ingrese un entero: ")
    return readLine()!!.toInt()
}

fun main(args: Array<String>) {
    val lista1: List<Int> = List(5) { cargar() }
    println(lista1)
}