fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    // Lee el valor ingresado y lo convierte a entero, guardándolo en 'valor1'
    val valor1 = readln().toInt()

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    // Lee el valor ingresado y lo convierte a entero, guardándolo en 'valor2'
    val valor2 = readln().toInt()

    // Solicita al usuario que ingrese el tercer valor
    print("Ingrese tercer valor:")
    // Lee el valor ingresado y lo convierte a entero, guardándolo en 'valor3'
    val valor3 = readln().toInt()

    // Compara los tres valores para encontrar el mayor
    if (valor1 > valor2) {
        // Si 'valor1' es mayor que 'valor2', entonces se compara con 'valor3'
        if (valor1 > valor3)
        // Si 'valor1' es mayor que 'valor3', entonces es el mayor valor
            print(valor1)
        else
        // Si 'valor3' es mayor que 'valor1', entonces 'valor3' es el mayor
            print(valor3)
    } else {
        // Si 'valor2' es mayor que 'valor1', entonces se compara con 'valor3'
        if (valor2 > valor3)
        // Si 'valor2' es mayor que 'valor3', entonces es el mayor valor
            print(valor2)
        else
        // Si 'valor3' es mayor que 'valor2', entonces 'valor3' es el mayor
            print(valor3)
    }
}
