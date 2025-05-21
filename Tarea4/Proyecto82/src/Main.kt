// Función que recibe tres enteros y devuelve el promedio como un número decimal (Double)
fun retornarPromedio(v1: Int, v2: Int, v3: Int): Double {
    val promedio = (v1 + v2 + v3) / 3.0  // Usamos 3.0 para que la división sea con decimales
    return promedio                        // Devolvemos el promedio como Double
}

fun main(parametro: Array<String>) {
    // Se piden tres valores al usuario
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()

    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()

    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()

    // Se llama a la función retornarPromedio y se imprime el resultado con decimales
    println("Valor promedio de los tres números ingresados es ${retornarPromedio(valor1, valor2, valor3)}")
}
