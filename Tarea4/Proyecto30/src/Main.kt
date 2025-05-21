fun main(parametro: Array<String>) {
    // Se piden tres valores al usuario
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()  // Primer valor ingresado
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()  // Segundo valor ingresado
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()  // Tercer valor ingresado

    // Determinar el menor valor usando una estructura condicional if
    val menor = if (valor1 < valor2 && valor1 < valor3) valor1 else if (valor2 < valor3) valor2 else valor3

    // Determinar el mayor valor usando una estructura condicional if
    val mayor = if (valor1 > valor2 && valor1 > valor3) valor1 else if (valor2 > valor3) valor2 else valor3

    // Mostrar el resultado
    print("El mayor de la lista es $mayor y el menor $menor")
}
