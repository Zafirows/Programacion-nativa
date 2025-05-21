fun main(parametro: Array<String>) {
    do {
        // Solicita al usuario ingresar un valor comprendido entre 0 y 999
        print("Ingrese un valor comprendido entre 0 y 999:")
        val valor = readln().toInt()   // Convierte el valor ingresado a un número entero

        // Verifica cuántos dígitos tiene el número ingresado
        if (valor < 10)
            println("El valor ingresado tiene un dígito")  // Si el número es menor a 10, tiene un dígito
        else
            if (valor < 100)
                println("El valor ingresado tiene dos dígitos")  // Si es menor a 100, tiene dos dígitos
            else
                println("El valor ingresado tiene tres dígitos")  // Si es menor a 1000, tiene tres dígitos

    } while (valor != 0)  // El ciclo se repite hasta que el usuario ingrese el valor 0
}
