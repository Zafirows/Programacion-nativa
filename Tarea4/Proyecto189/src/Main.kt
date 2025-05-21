// Esta función genera un cartón de lotería con 6 números aleatorios únicos entre 1 y 50
fun generarCarton(): Set<Int> {
    return (1..50).shuffled().take(6).toSet()
    // (1..50) → genera una secuencia del 1 al 50
    // shuffled() → desordena aleatoriamente los elementos
    // take(6) → toma los primeros 6 elementos
    // toSet() → convierte la lista en un conjunto (sin duplicados)
}

// Esta función genera una lista con los números del bolillero del 1 al 50 en orden aleatorio
fun generarBolillero(): List<Int> {
    return (1..50).shuffled()
    // Aquí se genera una lista con los números del 1 al 50 desordenados
}

// Esta función verifica cuántas bolillas se deben sacar hasta que el cartón acierte las 6
fun verificarTriunfo(carton: Set<Int>, bolillero: List<Int>) {
    var aciertos = 0          // Contador de aciertos (coincidencias con el cartón)
    var cantBolillas = 0      // Cantidad de bolillas sacadas

    // Se recorre cada bolilla extraída
    for (bolilla in bolillero) {
        cantBolillas++
        if (bolilla in carton) {   // Si el número de la bolilla está en el cartón
            aciertos++
            if (aciertos == 6) break  // Si ya acertó las 6, se detiene el ciclo
        }
    }

    // Se muestra cuántas bolillas se necesitaron para ganar
    println("Se sacaron $cantBolillas bolillas hasta que el cartón ganó.")
}

fun main() {
    // Generamos el cartón de 6 números
    val carton = generarCarton()
    println("Cartón de lotería generado:")
    println(carton)

    // Generamos el bolillero (lista de 50 números desordenados)
    val bolillero = generarBolillero()
    println("Números del bolillero:")
    println(bolillero)

    // Verificamos cuántas bolillas se sacaron hasta ganar
    verificarTriunfo(carton, bolillero)
}
