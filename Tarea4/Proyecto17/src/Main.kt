fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un valor entero entre 1 y 99
    print("Ingrese un valor entero comprendido entre 1 y 99:")
    // Lee la entrada del usuario, la convierte a entero y la guarda en 'valor'
    val valor = readln().toInt()

    // Se utiliza una expresión 'if' para determinar la cantidad de dígitos
    // Si el valor es menor que 10, tiene 1 dígito, de lo contrario tiene 2 dígitos
    var cantidad = if (valor < 10) 1 else 2

    // Imprime la cantidad de dígitos del número ingresado
    println("El número $valor tiene $cantidad dígito/s")
}

