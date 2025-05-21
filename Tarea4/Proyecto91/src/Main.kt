// Función que recibe un nombre (cadena de texto) y retorna su longitud (cantidad de caracteres)
fun largo(nombre: String) = nombre.length

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer nombre
    print("Ingrese un nombre:")
    val nombre1 = readln() // Lee el primer nombre ingresado por el usuario

    // Solicita al usuario que ingrese el segundo nombre
    print("Ingrese otro nombre:")
    val nombre2 = readln() // Lee el segundo nombre ingresado por el usuario

    // Compara la longitud de ambos nombres
    if (largo(nombre1) == largo(nombre2))
    // Si tienen la misma cantidad de caracteres, imprime un mensaje indicando eso
        print("Los nombres: $nombre1 y $nombre2 tienen la misma cantidad de caracteres")
    else
    // Si no tienen la misma longitud, determina cuál es más largo
        if (largo(nombre1) > largo(nombre2))
        // Si el primer nombre es más largo, lo indica
            print("$nombre1 es más largo")
        else
        // Si el segundo nombre es más largo, lo indica
            print("$nombre2 es más largo")
}
