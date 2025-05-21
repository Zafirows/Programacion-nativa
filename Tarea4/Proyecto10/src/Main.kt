fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el sueldo del empleado
    print("Ingrese el sueldo del empleado:")
    // Lee la entrada desde el teclado y la convierte a tipo Double (para permitir decimales)
    val sueldo = readln().toDouble()

    // Verifica si el sueldo es mayor a 3000
    if (sueldo > 3000) {
        // Si el sueldo es mayor a 3000, imprime que debe pagar impuestos
        println("Debe pagar impuestos")
    }
}
