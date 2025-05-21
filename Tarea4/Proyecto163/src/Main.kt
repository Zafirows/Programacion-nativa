// Clase Vector con sobrecarga del operador * para producto escalar con un entero
class Vector {
    val arreglo = IntArray(5)

    fun cargar() {
        for (i in arreglo.indices)
            arreglo[i] = (Math.random() * 11 + 1).toInt()
    }

    fun imprimir() {
        for (elemento in arreglo)
            print("$elemento ")
        println()
    }

    operator fun times(valor: Int): Vector {
        val resultado = Vector()
        for (i in arreglo.indices)
            resultado.arreglo[i] = arreglo[i] * valor
        return resultado
    }
}

fun main(args: Array<String>) {
    val vec1 = Vector()
    vec1.cargar()
    vec1.imprimir()

    println("El producto de un vector con el número 10 es")
    val vecProductoEnt = vec1 * 10
    vecProductoEnt.imprimir()
}