fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un número entero positivo entre 1 y 99999
    print("Ingrese un valor entero positivo comprendido entre 1 y 99999:")

    // Lee la entrada del usuario y la convierte a un entero
    val valor = readln().toInt()

    // Usa la estructura 'when' para determinar cuántos dígitos tiene el número ingresado
    when (valor) {
        in 1..9 -> print("Tiene 1 dígito")         // Si el número está entre 1 y 9
        in 10..99 -> print("Tiene 2 dígitos")      // Si está entre 10 y 99
        in 100..999 -> print("Tiene 3 dígitos")    // Si está entre 100 y 999
        in 1000..9999 -> print("Tiene 4 dígitos")  // Si está entre 1000 y 9999
        in 10000..99999 -> print("Tiene 5 dígitos")// Si está entre 10000 y 99999
        else -> print("No se encuentra comprendido en el rango indicado") // Si no está en el rango
    }
}
