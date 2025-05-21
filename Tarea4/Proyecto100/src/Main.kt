// Verifica si los elementos de un arreglo están ordenados de menor a mayor
fun main(parametro: Array<String>) {
    val arreglo = IntArray(10)
    for(i in 0 until arreglo.size) {
        print("Ingrese elemento:")
        arreglo[i] = readLine()!!.toInt()
    }
    var ordenado = true
    for(i in 0 until arreglo.size - 1)
        if (arreglo[i+1] < arreglo[i])
            ordenado = false
    if (ordenado)
        print("Los elementos están ordenados de menor a mayor")
    else
        print("Los elementos no están ordenados de menor a mayor")
}