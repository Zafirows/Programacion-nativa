// Se define un objeto "Mayor" usando `object`, lo que significa que es un singleton (una única instancia).
// Dentro de él hay tres funciones llamadas "maximo", sobrecargadas para distintos tipos de datos:
// Int, Float y Double. Cada una retorna el valor mayor entre dos números del mismo tipo.
object Mayor {
    // Función que recibe dos enteros y retorna el mayor.
    fun maximo(x1: Int, x2: Int) = if (x1 > x2) x1 else x2

    // Función que recibe dos números flotantes (Float) y retorna el mayor.
    fun maximo(x1: Float, x2: Float) = if (x1 > x2) x1 else x2

    // Función que recibe dos números decimales (Double) y retorna el mayor.
    fun maximo(x1: Double, x2: Double) = if (x1 > x2) x1 else x2
}

// Función principal del programa donde se hacen pruebas con el objeto "Mayor".
fun main(parametro: Array<String>) {
    // Llama a la función maximo con dos enteros (Int): 4 y 5.
    // Retorna e imprime el mayor de los dos: 5
    println(Mayor.maximo(4, 5))

    // Llama a la función maximo con dos flotantes (Float): 10.2f y 23.5f.
    // Retorna e imprime el mayor: 23.5
    println(Mayor.maximo(10.2f, 23.5f))

    // Llama a la función maximo con dos dobles (Double): 4.5 y 5.2.
    // Retorna e imprime el mayor: 5.2
    println(Mayor.maximo(4.5, 5.2))
}
