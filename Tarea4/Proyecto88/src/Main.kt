// Función que recibe tres enteros y retorna su promedio entero.
// Se utiliza una expresión de una sola línea (expresión abreviada).
fun retornarPromedio(v1: Int, v2: Int, v3: Int) = (v1 + v2 + v3) / 3

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    val valor1 = readln().toInt() // Lee la entrada del usuario y la convierte a Int

    // Solicita el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()

    // Solicita el tercer valor
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()

    // Llama a la función 'retornarPromedio' con los tres valores y muestra el resultado
    println("Valor promedio de los tres números ingresados es ${retornarPromedio(valor1, valor2, valor3)}")
}
