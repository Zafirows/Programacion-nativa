// Arreglo de objetos Persona y uso de forEach para contar mayores de edad
class Persona(val nombre: String, val edad: Int) {
    fun imprimir() {
        println("Nombre: $nombre Edad: $edad")
    }

    fun esMayor() = edad >= 18
}

fun main(parametro: Array<String>) {
    val personas: Array<Persona> = arrayOf(
        Persona("ana", 22),
        Persona("juan", 13),
        Persona("carlos", 6),
        Persona("maria", 72)
    )
    println("Listado de personas")
    for (per in personas)
        per.imprimir()

    var cant = 0
    personas.forEach {
        if (it.esMayor())
            cant++
    }
    println("Cantidad de personas mayores de edad: $cant")
}