// Se define una función de extensión para la clase String
fun String.imprimir() {
    // Dentro de la función, se imprime el valor de la cadena (this hace referencia a la propia cadena)
    println(this)
}

fun main(args: Array<String>) {
    // Se llama a la función imprimir directamente sobre el string "Hola Mundo"
    "Hola Mundo".imprimir()

    // Se crea una variable cadena1 que contiene la cadena "Fin"
    val cadena1 = "Fin"

    // Se llama a la función imprimir sobre la variable cadena1
    cadena1.imprimir()
}
