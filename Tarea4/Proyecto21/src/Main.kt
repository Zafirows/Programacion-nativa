fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un valor entero con 1, 2 o 3 cifras
    print("Ingrese un valor entero con 1,2 o 3 cifras:")
    // Lee el valor ingresado y lo convierte a entero, guardándolo en 'valor'
    val valor = readln().toInt()

    // Compara el valor ingresado para determinar la cantidad de dígitos
    if (valor < 10)
    // Si el valor tiene solo un dígito (menor que 10), imprime "Tiene un dígito"
        println("Tiene un dígito")
    else
    // Si el valor tiene dos dígitos (menor que 100), imprime "Tiene dos dígitos"
        if (valor < 100)
            println("Tiene dos dígitos")
        else
        // Si el valor tiene tres dígitos (menor que 1000), imprime "Tiene tres dígitos"
            if (valor < 1000)
                println("Tiene tres dígitos")
            else
            // Si el valor es mayor o igual a 1000, imprime un error en la entrada de datos
                println("Error en la entrada de datos.")
}
