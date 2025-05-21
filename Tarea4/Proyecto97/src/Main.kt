// Función que se encarga de mostrar el mayor entre dos números, repitiéndose 5 veces
fun mostrarMayor() {

    // Función interna que compara dos números y retorna el mayor
    fun mayor(x1: Int, x2: Int) = if (x1 > x2) x1 else x2

    // Bucle que se repite 5 veces
    for(i in 1..5) {
        // Solicita el primer valor al usuario
        print("Ingrese primer valor:")
        val valor1 = readln().toInt() // Lee y convierte a entero

        // Solicita el segundo valor al usuario
        print("Ingrese segundo valor:")
        val valor2 = readln().toInt() // Lee y convierte a entero

        // Muestra cuál de los dos valores es mayor
        println("El mayor entre $valor1 y $valor2 es ${mayor(valor1, valor2)}")
    }
}

// Función principal que llama a mostrarMayor
fun main(parametro: Array<String>) {
    mostrarMayor()
}
