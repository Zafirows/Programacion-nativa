fun main(parametros: Array<String>) {
    var cant = 0 // Variable para contar cuántos números pares se ingresan

    print("Cuantos valores ingresará para analizar:")
    val cantidad = readln().toInt() // Se pide al usuario que indique cuántos números va a ingresar

    // Bucle que se repite desde 1 hasta la cantidad indicada por el usuario
    for(i in 1..cantidad) {
        print("Ingrese valor:")
        val valor = readln().toInt() // Se lee un número entero

        if (valor % 2 == 0) // Se verifica si el número es par (el residuo de dividir entre 2 es 0)
            cant++ // Si es par, se incrementa el contador
    }

    // Al finalizar el bucle, se muestra cuántos números pares se ingresaron
    println("Cantidad de pares: $cant")
}
