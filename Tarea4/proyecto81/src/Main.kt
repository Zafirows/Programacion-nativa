// Función que retorna la cantidad de caracteres de un nombre
fun largo(nombre: String): Int {
    return nombre.length
}

fun main(parametro: Array<String>) {
    print("Ingrese un nombre: ")
    val nombre1 = readln()

    print("Ingrese otro nombre: ")
    val nombre2 = readln()

    // Comparamos las longitudes usando la función largo()
    if (largo(nombre1) == largo(nombre2)) {
        println("Los nombres: $nombre1 y $nombre2 tienen la misma cantidad de caracteres")
    } else if (largo(nombre1) > largo(nombre2)) {
        println("$nombre1 es más largo")
    } else {
        println("$nombre2 es más largo")
    }
}
