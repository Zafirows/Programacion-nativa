fun main(parametro: Array<String>) {
    // Inicialización de la variable que acumulará los saldos acreedores
    var suma = 0.0

    // Bucle do-while para ingresar información de las cuentas
    do {
        // Solicitar al usuario que ingrese el número de cuenta
        print("Ingrese número de cuenta:")
        val cuenta = readln().toInt()

        // Verificar que la cuenta sea válida (mayor o igual a 0)
        if (cuenta >= 0) {
            // Solicitar al usuario que ingrese el saldo de la cuenta
            print("Ingrese saldo:")
            val saldo = readln().toDouble()

            // Clasificar el saldo según su valor
            if (saldo > 0) {
                // Si el saldo es positivo, es un saldo acreedor, y se acumula en la variable suma
                println("Saldo Acreedor.")
                suma += saldo
            } else if (saldo < 0) {
                // Si el saldo es negativo, es un saldo deudor
                println("Saldo Deudor.")
            } else {
                // Si el saldo es igual a 0, es un saldo nulo
                println("Saldo Nulo.")
            }
        }
    } while (cuenta >= 0) // El bucle continuará hasta que se ingrese una cuenta negativa

    // Al final, se imprime el total acumulado de saldos acreedores
    println("Total de saldos Acreedores: $suma")
}
