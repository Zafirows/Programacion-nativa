// Lista de objetos Persona y conteo de mayores de edad
class Persona(var nombre: String, var edad: Int) {
    fun imprimir() {
        println("Nombre: $nombre y tiene una edad de $edad")
    }

    fun esMayorEdad() {
        if (edad >= 18)
            println("Es mayor de edad $nombre")
        else
            println("No es mayor de edad $nombre")
    }
}

fun main(args: Array<String>) {
    val personas: MutableList<Persona> = mutableListOf(
        Persona("Juan", 22),
        Persona("Ana", 19),
        Persona("Marcos", 12)
    )

    println("Listado de todas las personas")
    personas.forEach { it.imprimir() }

    val cant = personas.count { it.edad >= 18 }
    println("La cantidad de personas mayores de edad es $cant")
}