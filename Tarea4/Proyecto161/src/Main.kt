// Definimos una función de extensión para la clase Int llamada `hasta`
// Esta función recibe otro entero llamado `fin` como parámetro
fun Int.hasta(fin: Int) {
    // Recorremos los valores desde el número actual (this) hasta el valor 'fin'
    for (valor in this..fin)
        print("$valor-") // Imprime cada valor seguido de un guion
    println() // Salto de línea al terminar
}
fun main(args: Array<String>) {
    val v = 10       // Se declara una variable entera con valor 10
    v.hasta(100)     // Se llama a la función `hasta` desde 10 hasta 100
    5.hasta(10)      // También se puede llamar directamente con un número literal (del 5 al 10)
}
