class Vector {
    // Se declara un arreglo de 5 enteros (valores iniciales serán 0)
    val arreglo = IntArray(5)

    // Método para cargar el arreglo con números aleatorios entre 1 y 11
    fun cargar() {
        for(i in arreglo.indices)
            arreglo[i] = (Math.random() * 11 + 1).toInt()
    }

    // Método para imprimir los elementos del arreglo separados por espacio
    fun imprimir() {
        for(elemento in arreglo)
            print("$elemento ")
        println()
    }

    // Sobrecarga del operador ++ (incremento)
    operator fun inc(): Vector {
        // Se crea un nuevo objeto Vector
        var suma1 = Vector()
        // Se copia cada valor del vector original sumándole 1
        for(i in arreglo.indices)
            suma1.arreglo[i] = arreglo[i] + 1
        return suma1 // Se devuelve el nuevo vector incrementado
    }

    // Sobrecarga del operador -- (decremento)
    operator fun dec(): Vector {
        // Se crea un nuevo objeto Vector
        var resta1 = Vector()
        // Se copia cada valor del vector original restándole 1
        for(i in arreglo.indices)
            resta1.arreglo[i] = arreglo[i] - 1
        return resta1 // Se devuelve el nuevo vector decrementado
    }
}
