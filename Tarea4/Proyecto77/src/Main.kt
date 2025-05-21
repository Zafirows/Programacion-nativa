// Función que compara dos claves ingresadas por el usuario
fun verificarClaves(clave1: String, clave2: String) {
    // Compara si ambas claves son exactamente iguales
    if (clave1 == clave2)
        println("Se ingresaron las dos veces la misma clave") // Muestra mensaje si son iguales
    else
        print("No se ingresó las dos veces con el mismo valor") // Muestra mensaje si son diferentes
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese la primera clave
    print("Ingrese primer clave;")
    val clave1 = readln()

    // Solicita al usuario que repita la misma clave
    print("Repita el ingreso de la misma clave;")
    val clave2 = readln()

    // Llama a la función verificarClaves con las dos entradas del usuario
    verificarClaves(clave1, clave2)
}
