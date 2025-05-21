// Clase Vector con operadores sobrecargados para suma, resta, multiplicación y división entre vectores
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

    operator fun plus(vector2: Vector): Vector {
        val suma = Vector()
        for (i in arreglo.indices)
            suma.arreglo[i] = arreglo[i] + vector2.arreglo[i]
        return suma
    }

    operator fun minus(vector2: Vector): Vector {
        val resta = Vector()
        for (i in arreglo.indices)
            resta.arreglo[i] = arreglo[i] - vector2.arreglo[i]
        return resta
    }

    operator fun times(vector2: Vector): Vector {
        val producto = Vector()
        for (i in arreglo.indices)
            producto.arreglo[i] = arreglo[i] * vector2.arreglo[i]
        return producto
    }

    operator fun div(vector2: Vector): Vector {
        val division = Vector()
        for (i in arreglo.indices)
            division.arreglo[i] = arreglo[i] / vector2.arreglo[i]
        return division
    }
}

fun main(args: Array<String>) {
    val vec1 = Vector()
    vec1.cargar()
    val vec2 = Vector()
    vec2.cargar()

    vec1.imprimir()
    vec2.imprimir()

    val vecSuma = vec1 + vec2
    println("Suma componente a componente de los dos vectores")
    vecSuma.imprimir()

    val vecResta = vec1 - vec2
    println("La resta componente a componente de los dos vectores")
    vecResta.imprimir()

    val vecProducto = vec1 * vec2
    println("El producto componente a componente de los dos vectores")
    vecProducto.imprimir()

    val vecDivision = vec1 / vec2
    println("La división componente a componente de los dos vectores")
    vecDivision.imprimir()
}