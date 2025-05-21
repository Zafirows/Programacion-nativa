fun main(parametro: Array<String>) {
    print("Ingrese primer valor:")  // Muestra un mensaje pidiendo el primer valor.
    val valor1 = readln().toInt()  // Lee el primer valor ingresado por el usuario y lo convierte a entero.

    print("Ingrese segundo valor:")  // Muestra un mensaje pidiendo el segundo valor.
    val valor2 = readln().toInt()  // Lee el segundo valor ingresado por el usuario y lo convierte a entero.

    print("Ingrese tercer valor:")  // Muestra un mensaje pidiendo el tercer valor.
    val valor3 = readln().toInt()  // Lee el tercer valor ingresado por el usuario y lo convierte a entero.

    // La condición if verifica si alguno de los tres valores es menor que 10.
    if (valor1 < 10 || valor2 < 10 || valor3 < 10)
        print("Alguno de los números es menor a diez")  // Si la condición es verdadera, imprime este mensaje.
}
