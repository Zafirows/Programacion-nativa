//CAPITULO 4 -Arrays
fun main() {
    // Crea un arreglo de enteros (tipo IntArray) con los valores 1, 2 y 3
    val intArray = intArrayOf(1, 2, 3)

    // Crea un arreglo de números con punto decimal (tipo DoubleArray)
    // con los valores 1.2 y 5.0
    val doubleArray = doubleArrayOf(1.2, 5.0)

    // Imprime el contenido de ambos arreglos en formato legible
    println("intArray: ${intArray.joinToString(", ")}")       // Salida: intArray: 1, 2, 3
    println("doubleArray: ${doubleArray.joinToString(", ")}") // Salida: doubleArray: 1.2, 5.0
}
