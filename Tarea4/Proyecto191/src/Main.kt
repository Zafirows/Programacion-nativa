// Esta función genera un cartón de lotería con 6 números aleatorios y únicos del 1 al 50
fun generarCarton(): Set<Int> {
    // Se crea una lista del 1 al 50, se mezcla aleatoriamente y se toman los primeros 6 números
    return (1..50).shuffled().take(6).toSet()
}

// Esta función genera el bolillero (los 50 números del sorteo) en orden aleatorio
fun generarBolillero(): List<Int> {
    // Se genera una lista del 1 al 50 y se mezcla aleatoriamente (como extraer bolillas una a una)
    return (1..50).shuffled()
}

// Esta función simula el proceso de sacar bolillas del bolillero hasta que se acierten los 6 números del cartón
fun verificarTriunfo(carton: Set<Int>, bolillero: List<Int>) {
    var aciertos = 0             // Contador de aciertos del cartón
    var cantBolillas = 0         // Contador de cuántas bolillas se han sacado

    // Recorremos el bolillero (los números extraídos en orden aleatorio)
    for (bolilla in bolillero) {
        cantBolillas++           // Cada número contado como una bolilla extraída

        // Si la bolilla está en el cartón, se considera un acierto
        if (bolilla in carton) {
            aciertos++
            // Si se logran 6 aciertos, se detiene el ciclo
            if (aciertos == 6) break
        }
    }

    // Mostramos cuántas bolillas se necesitaron para ganar
    println("Se sacaron $cantBolillas bolillas hasta que el cartón ganó.")
}

fun main() {
    // Se genera el cartón de lotería y se imprime
    val carton = generarCarton()
    println("Cartón de lotería generado:")
    println(carton)

    // Se genera el bolillero mezclado y se imprime
    val bolillero = generarBolillero()
    println("Números del bolillero:")
    println(bolillero)

    // Se simula el juego y se verifica en cuántos intentos se gana
    verificarTriunfo(carton, bolillero)
}
