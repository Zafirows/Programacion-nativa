fun main(parametro: Array<String>) {
    // Solicitar al usuario ingresar tres valores
    print("Ingrese primer valor: ")
    val num1 = readln().toInt()
    print("Ingrese segundo valor: ")
    val num2 = readln().toInt()
    print("Ingrese tercer valor: ")
    val num3 = readln().toInt()

    // Encontrar el valor máximo entre los tres
    val mayor = when {
        num1 > num2 && num1 > num3 -> num1
        num2 > num3 -> num2
        else -> num3
    }

    // Imprimir el número mayor
    println("El número mayor es: $mayor")
}
