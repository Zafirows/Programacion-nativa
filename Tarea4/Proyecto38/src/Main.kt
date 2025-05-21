fun main(parametro: Array<String>) {
    var termino = 11     // Primer número de la serie
    var x = 1            // Contador

    while (x <= 25) {    // Repite 25 veces
        println(termino)             // Imprime el número actual
        termino = termino + 11      // Suma 11 al número anterior
        x = x + 1                   // Incrementa el contador
    }
}
