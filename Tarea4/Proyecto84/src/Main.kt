// Función que calcula la superficie de un rectángulo, recibiendo como parámetros los lados del rectángulo
fun retornarSuperficie(lado1: Int, lado2: Int): Int {
    // Retorna la superficie, que es el producto de los dos lados (lado1 y lado2)
    return lado1 * lado2
}

fun main(parametro: Array<String>) {
    // Mensaje para indicar que el usuario ingresará datos para el primer rectángulo
    println("Primer rectangulo")

    // Solicita al usuario que ingrese el valor del lado menor del primer rectángulo
    print("Ingrese lado menor del rectangulo:")
    val lado1 = readln().toInt()  // Convierte la entrada del usuario a un entero

    // Solicita al usuario que ingrese el valor del lado mayor del primer rectángulo
    print("Ingrese lado mayor del rectangulo:")
    val lado2 = readln().toInt()  // Convierte la entrada del usuario a un entero

    // Mensaje para indicar que el usuario ingresará datos para el segundo rectángulo
    println("Segundo rectangulo")

    // Solicita al usuario que ingrese el valor del lado menor del segundo rectángulo
    print("Ingrese lado menor del rectangulo:")
    val lado3 = readln().toInt()  // Convierte la entrada del usuario a un entero

    // Solicita al usuario que ingrese el valor del lado mayor del segundo rectángulo
    print("Ingrese lado mayor del rectangulo:")
    val lado4 = readln().toInt()  // Convierte la entrada del usuario a un entero

    // Compara las superficies de los dos rectángulos
    if (retornarSuperficie(lado1, lado2) == retornarSuperficie(lado3, lado4)) {
        // Si las superficies son iguales, se imprime este mensaje
        print("Los dos rectangulos tienen la misma superficie")
    } else {
        // Si la superficie del primer rectángulo es mayor que la del segundo
        if (retornarSuperficie(lado1, lado2) > retornarSuperficie(lado3, lado4)) {
            // Imprime que el primer rectángulo tiene una superficie mayor
            print("El primer rectangulo tiene una superficie mayor")
        } else {
            // Si la superficie del segundo rectángulo es mayor que la del primero
            // Imprime que el segundo rectángulo tiene una superficie mayor
            print("El segundo rectangulo tiene una superficie mayor")
        }
    }
}
