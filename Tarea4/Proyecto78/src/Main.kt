// Función que ordena tres números enteros de menor a mayor y los muestra
fun ordenarMayorMenor(valor1: Int, valor2: Int, valor3: Int) {
    when {
        // Si valor1 es el menor
        valor1 < valor2 && valor1 < valor3 -> {
            if (valor2 < valor3)
                println("$valor1 $valor2 $valor3")
            else
                println("$valor1 $valor3 $valor2")
        }
        // Si valor2 es el menor
        valor2 < valor3 -> {
            if (valor1 < valor3)
                println("$valor2 $valor1 $valor3")
            else
                println("$valor2 $valor3 $valor1")
        }
        // Si valor3 es el menor
        else -> {
            if (valor1 < valor2)
                println("$valor3 $valor1 $valor2")
            else
                println("$valor3 $valor2 $valor1")
        }
    }
}

// Función principal: pide al usuario tres números e invoca la función para ordenarlos
fun main(parametros: Array<String>) {
    print("Ingrese primer valor: ")
    val valor1 = readln().toInt()

    print("Ingrese segundo valor: ")
    val valor2 = readln().toInt()

    print("Ingrese tercer valor: ")
    val valor3 = readln().toInt()

    // Llama a la función para mostrar los valores ordenados
    ordenarMayorMenor(valor1, valor2, valor3)
}
