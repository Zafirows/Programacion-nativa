// Clase Vector con sobrecarga del operador +=
class Vector {
    val arreglo = IntArray(5) { it }

    fun imprimir() {
        for (elemento in arreglo)
            print("$elemento ")
        println()
    }

    // Sobrecarga del operador += para sumar vectores componente a componente
    operator fun plusAssign(vec2: Vector) {
        for (i in arreglo.indices)
            arreglo[i] += vec2.arreglo[i]
    }
}

fun main(args: Array<String>) {
    val vec1 = Vector()
    vec1.imprimir()

    val vec2 = Vector()
    vec2.imprimir()

    vec1 += vec2
    vec1.imprimir()
}