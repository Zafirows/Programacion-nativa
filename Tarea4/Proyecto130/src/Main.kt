// Clase 'Dado' como data class, con un solo atributo: 'valor'
data class Dado (var valor: Int) {

    // Sobrescribe el método toString() para personalizar cómo se imprime el objeto
    override fun toString(): String {
        var cadena = ""
        for(i in 1..valor)
            cadena += "*" // Agrega un asterisco por cada número en el valor
        return cadena
    }
}
fun main(parametro: Array<String>) {
    val dado1 = Dado(4)   // 4 asteriscos
    val dado2 = Dado(6)   // 6 asteriscos
    val dado3 = Dado(1)   // 1 asterisco
    println(dado1)        // ****
    println(dado2)        // ******
    println(dado3)        // *
}
