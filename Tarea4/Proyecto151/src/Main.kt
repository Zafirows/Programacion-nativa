// Función que filtra caracteres de una cadena según un criterio
fun filtrar(cadena: String, fn: (Char) -> Boolean): String {
    val cad = StringBuilder()
    for (ele in cadena)
        if (fn(ele))
            cad.append(ele)
    return cad.toString()
}

fun main(parametro: Array<String>) {
    val cadena = "¿Esto es la prueba 1 o la prueba 2?"
    println("String original")
    println(cadena)

    val resultado1 = filtrar(cadena) {
        it.lowercaseChar() in "aeiou"
    }
    println("Solo las vocales")
    println(resultado1)

    val resultado2 = filtrar(cadena) {
        it in 'a'..'z'
    }
    println("Solo los caracteres en minúsculas")
    println(resultado2)

    val resultado3 = filtrar(cadena) {
        it !in 'a'..'z' && it !in 'A'..'Z'
    }
    println("Solo los caracteres no alfabéticos")
    println(resultado3)
}