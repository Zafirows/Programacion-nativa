// Función que determina el menor de tres valores ingresados
fun menorValor() {
    print("Ingrese primer valor:")              // Solicita el primer número al usuario
    val valor1 = readln().toInt()               // Lee el primer valor como entero
    print("Ingrese segundo valor:")             // Solicita el segundo número
    val valor2 = readln().toInt()               // Lee el segundo valor
    print("Ingrese tercer valor:")              // Solicita el tercer número
    val valor3 = readln().toInt()               // Lee el tercer valor
    print("Menor de los tres:")                 // Muestra mensaje previo al resultado
    when {
        // Compara y determina cuál es el menor valor entre los tres
        valor1 < valor2 && valor1 < valor3 -> println(valor1)
        valor2 < valor3 -> println(valor2)
        else -> println(valor3)
    }
}

// Función principal que llama dos veces a la función menorValor
fun main(parametro: Array<String>) {
    menorValor()      // Llama la primera vez a la función para pedir 3 números y mostrar el menor
    menorValor()      // Llama una segunda vez, repitiendo el mismo proceso
}
