//CAPITULO 5 -Bucles en kotlin
fun main() {
    // Crea un mapa (mapa inmutable) con claves enteras y valores de tipo String
    // El mapa contiene las siguientes asociaciones:
    // 1 -> "foo", 2 -> "bar", 3 -> "baz"
    val map = mapOf(1 to "foo", 2 to "bar", 3 to "baz")

    // Recorre el mapa usando un bucle for-each
    // Desestructura cada entrada en 'key' y 'value'
    for ((key, value) in map) {
        // Imprime cada par clave-valor en formato: Map[clave] = valor
        println("Map[$key] = $value")
    }
}
