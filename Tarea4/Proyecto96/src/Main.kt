// Esta función principal analiza cuántos de los números ingresados son múltiplos de 2 y de 5
fun multiplos2y5() {

    // Función interna que determina si un número es múltiplo de otro
    // Devuelve true si el número es divisible sin residuo (modulo % == 0)
    fun multiplo(numero: Int, valor: Int) = numero % valor == 0

    // Contadores para múltiplos de 2 y 5
    var mult2 = 0
    var mult5 = 0

    // Se repite 10 veces para pedir al usuario un número en cada iteración
    for(i in 1..10) {
        print("Ingrese valor:")
        val valor = readln().toInt() // Lee un número del teclado y lo convierte a entero

        // Si el número es múltiplo de 2, incrementa el contador correspondiente
        if (multiplo(valor, 2))
            mult2++

        // Si el número es múltiplo de 5, incrementa el otro contador
        if (multiplo(valor, 5))
            mult5++
    }

    // Al finalizar las 10 entradas, muestra cuántos múltiplos de 2 y de 5 hubo
    println("Cantidad de múltiplos de 2 : $mult2")
    println("Cantidad de múltiplos de 5 : $mult5")
}

// Función principal desde donde se llama a la función multiplos2y5()
fun main(parametro: Array<String>) {
    multiplos2y5()
}
