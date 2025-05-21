fun main(parametro: Array<String>) {
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()   // Leemos el primer valor e intentamos convertirlo a un número entero
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()   // Leemos el segundo valor e intentamos convertirlo a un número entero
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()   // Leemos el tercer valor e intentamos convertirlo a un número entero

    // Condicional para verificar si los tres valores son iguales
    if (valor1 == valor2 && valor1 == valor3) {
        // Si los tres valores son iguales, se calcula el cubo del primer valor (en este caso el cubo de valor1)
        val cubo = valor1 * valor1 * valor3
        print("El cubo de $valor1 es $cubo")  // Imprime el cubo calculado
    }
}
