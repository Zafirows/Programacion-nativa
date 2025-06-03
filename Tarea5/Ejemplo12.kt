//CAPITULO 5 -Bucles en kotlin
fun main() {
    // Crea una lista inmutable de Strings con tres elementos: "Hello", "World" y "!"
    val list = listOf("Hello", "World", "!")

    // Recorre cada elemento de la lista usando un bucle for-each
    for (str in list) {
        print(str) // Imprime cada elemento sin salto de línea
    }
}
