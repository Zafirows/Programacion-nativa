fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un valor entero
    print("Ingrese un valor entero:")
    // Lee el valor ingresado y lo convierte a entero, guardándolo en 'valor'
    val valor = readln().toInt()

    // Compara el valor ingresado
    if (valor == 0)
    // Si el valor es igual a 0, imprime "Se ingresó el cero"
        println("Se ingresó el cero")
    else
    // Si el valor no es 0, entra en una nueva comparación
        if (valor > 0)
        // Si el valor es mayor que 0, imprime "Se ingresó un valor positivo"
            println("Se ingresó un valor positivo")
        else
        // Si el valor es menor que 0, imprime "Se ingresó un valor negativo"
            println("Se ingresó un valor negativo")
}

