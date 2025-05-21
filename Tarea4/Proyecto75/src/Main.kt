// Función que recibe tres valores enteros y muestra cuál es el mayor
fun mostrarMayor(v1: Int, v2: Int, v3: Int) {
    print("Mayor:")  // Imprime el texto antes de mostrar el valor mayor
    if (v1 > v2 && v1 > v3)         // Si v1 es mayor que v2 y v3
        println(v1)                 // Imprime v1
    else
        if (v2 > v3)                // Si v1 no es el mayor, compara v2 y v3
            print(v2)              // Imprime v2 si es mayor que v3
        else
            print(v3)              // Si no, imprime v3 porque es el mayor
}

// Función principal
fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese tres valores
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()

    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()

    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()

    // Llama a la función para determinar y mostrar el mayor de los tres
    mostrarMayor(valor1, valor2, valor3)
}
