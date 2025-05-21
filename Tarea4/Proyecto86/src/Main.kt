// Definición de la función 'retornarMayor', que toma dos enteros como parámetros
// y devuelve el mayor de los dos. Utiliza una expresión 'if' como una forma compacta de escribir el código.
fun retornarMayor(v1: Int, v2: Int) = if (v1 > v2) v1 else v2

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor y lo almacena en la variable 'valor1'
    print("Ingrese el primer valor:")
    val valor1 = readln().toInt()  // Convierte la entrada a un entero

    // Solicita al usuario que ingrese el segundo valor y lo almacena en la variable 'valor2'
    print("Ingrese el segundo valor:")
    val valor2 = readln().toInt()  // Convierte la entrada a un entero

    // Llama a la función 'retornarMayor' pasando los valores 'valor1' y 'valor2' como argumentos
    // Luego, imprime el mayor de los dos valores usando la interpolación de cadenas en Kotlin.
    println("El mayor entre $valor1 y $valor2 es ${retornarMayor(valor1, valor2)}")
}
