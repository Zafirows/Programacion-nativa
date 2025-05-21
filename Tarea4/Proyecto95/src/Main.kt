// Función que imprime la tabla de multiplicar de un número hasta cierta cantidad de términos.
// Parámetros:
// - numero: el número base cuya tabla queremos mostrar.
// - terminos: la cantidad de términos a mostrar (por defecto es 10).
fun tabla(numero: Int, terminos: Int = 10) {
    // Usamos un bucle que inicia en 'numero' y se incrementa en pasos de 'numero'
    // hasta llegar a numero * terminos (inclusive si coincide).
    for (i in numero..numero * terminos step numero)
        println(i)
}

fun main(parametro: Array<String>) {
    println("Tabla del 3")
    tabla(3) // Imprime la tabla del 3 hasta 10 términos: 3, 6, 9, ..., 30

    println("Tabla del 3 con 5 terminos")
    tabla(3, 5) // Imprime la tabla del 3 hasta 5 términos: 3, 6, 9, 12, 15

    println("Tabla del 3 con 20 terminos")
    tabla(terminos = 20, numero = 3) // Uso de argumentos nombrados. Imprime del 3 al 60 en pasos de 3
}
