//CAPITULO 4 -Arrays
fun main() {
    // Crea un arreglo de tamaño5
    // Cada elemento se inicializa con el cuadrado del índice (i * i), convertido a String
    // Resultado: ["0", "1", "4", "9", "16"]
    val asc = Array(5) { i -> (i * i).toString() }

    // Recorre el array con un bucle for-each
    // En cada iteración imprime el valor del elemento actual
    for (s in asc) {
        println(s)
    }
}
