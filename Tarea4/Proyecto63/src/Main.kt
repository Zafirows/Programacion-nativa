fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un número entero
    print("Ingrese un valor entero:")

    // Lee la entrada del usuario como texto y la convierte a un número entero
    val valor = readln().toInt()

    // Utiliza la estructura 'when' para verificar el valor ingresado
    when {
        valor == 0 ->
            // Si el valor es igual a 0, se imprime este mensaje
            println("Se ingresó el cero")
        valor > 0 ->
            // Si el valor es mayor que 0, se imprime este mensaje
            println("Se ingresó un valor positivo")
        else ->
            // Si el valor no es ni 0 ni mayor que 0, entonces es negativo
            println("Se ingresó un valor negativo")
    }
}
