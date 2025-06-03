//CAPITULO 6 -Colecciones
fun main() {
    // Crea un mapa inmutable (no modificable) con claves de tipo Int y valores de tipo String
    val map = mapOf(
        1 to "Item 1",
        2 to "Item 2",
        3 to "Item 3"
    )

    // Imprime todo el contenido del mapa
    // Kotlin muestra los pares clave-valor en formato: {1=Item 1, 2=Item 2, 3=Item 3}
    println(map)
}
