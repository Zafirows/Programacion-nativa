fun main(parametro: Array<String>) {
    var mult8 = 8                     // Comienza desde 8
    while (mult8 <= 500) {            // Mientras no pase de 500
        print("$mult8 -")             // Imprime el múltiplo seguido de un guion
        mult8 = mult8 + 8             // Suma 8 para el siguiente múltiplo
    }
}
