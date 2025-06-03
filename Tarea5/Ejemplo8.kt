//CAPITULO 4 -Arrays
fun main() {
    // Crea un array vacío de tipo String
    // No contiene ningún elemento, y su tamaño es 0
    val empty = emptyArray<String>()

    // Crea un array de tamaño 5
    // Cada elemento se inicializa con el texto "Item #<índice>"
    // Resultado inicial: ["Item #0", "Item #1", "Item #2", "Item #3", "Item #4"]
    val strings = Array<String>(5) { i -> "Item #$i" }

    // Modifica el valor en la posición 2 (tercer elemento)
    // Ahora el array queda así: ["Item #0", "Item #1", "ChangedItem", "Item #3", "Item #4"]
    strings[2] = "ChangedItem"

    // Imprime el contenido del array para verificar los cambios
    println(strings.joinToString(prefix = "[", postfix = "]", separator = ", "))
}
