fun main(parametro: Array<String>) {
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()  // El primer valor ingresado por el usuario se almacena en la variable valor1.
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()  // El segundo valor ingresado por el usuario se almacena en la variable valor2.
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()  // El tercer valor ingresado por el usuario se almacena en la variable valor3.

    // Condición que verifica si los tres valores son menores a 10
    if (valor1 < 10 && valor2 < 10 && valor3 < 10)
        println("Todos los números son menores a diez")  // Si la condición es verdadera, imprime este mensaje.
}
