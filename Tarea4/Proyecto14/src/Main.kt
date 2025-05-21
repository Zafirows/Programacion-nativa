fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un valor comprendido entre 1 y 99
    print("Ingrese un valor comprendido entre 1 y 99:")
    // Lee la entrada y la convierte a entero, almacenándola en la variable 'num'
    val num = readln().toInt()

    // Verifica si el número tiene menos de 10
    if (num < 10)
    // Si 'num' es menor que 10, significa que tiene un solo dígito
        println("Tiene un dígito")
    else
    // Si 'num' tiene 10 o más, significa que tiene dos dígitos
        println("Tiene dos dígitos")
}
