// Definición de la función 'convertirCastelano', que toma un valor entero como parámetro
// y devuelve una cadena que representa ese valor en español. Si el valor no está en el rango de 1 a 5, devuelve "error".
fun convertirCastelano(valor: Int) = when (valor) {
    1 -> "uno"      // Si 'valor' es 1, devuelve "uno"
    2 -> "dos"      // Si 'valor' es 2, devuelve "dos"
    3 -> "tres"     // Si 'valor' es 3, devuelve "tres"
    4 -> "cuatro"   // Si 'valor' es 4, devuelve "cuatro"
    5 -> "cinco"    // Si 'valor' es 5, devuelve "cinco"
    else -> "error" // Si 'valor' no es 1, 2, 3, 4 o 5, devuelve "error"
}

fun main(parametro: Array<String>) {
    // Un bucle 'for' que recorre los números del 1 al 6 (inclusive)
    for(i in 1..6) {
        // Para cada número en el rango, llama a la función 'convertirCastelano'
        // y imprime el resultado (el valor convertido a español o "error").
        println(convertirCastelano(i))
    }
}
