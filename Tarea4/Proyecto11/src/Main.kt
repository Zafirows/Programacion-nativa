fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'valor1'
    val valor1 = readln().toInt()

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'valor2'
    val valor2 = readln().toInt()

    // Compara si 'valor1' es mayor que 'valor2'
    if (valor1 > valor2)
    // Si 'valor1' es mayor, imprime que el mayor valor es 'valor1'
        print("El mayor valor es $valor1")
    else
    // Si no, imprime que el mayor valor es 'valor2'
        print("El mayor valor es $valor2")
}