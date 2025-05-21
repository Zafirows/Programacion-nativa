// Paso de funciones como criterio para determinar mayoría de edad

// Clase Persona con función que recibe un criterio para evaluar edad
class Persona(val nombre: String, val edad: Int) {
    fun esMayor(fn:(Int) -> Boolean): Boolean {
        return fn(edad)
    }
}

// Función que define mayoría de edad en Estados Unidos (21+)
fun mayorEstadosUnidos(edad: Int): Boolean {
    return edad >= 21
}

// Función que define mayoría de edad en Argentina (18+)
fun mayorArgentina(edad: Int): Boolean {
    return edad >= 18
}

fun main(parametro: Array<String>) {
    val persona1 = Persona("juan", 18)

    if (persona1.esMayor(::mayorArgentina))
        println("${persona1.nombre} es mayor si vive en Argentina")
    else
        println("${persona1.nombre} no es mayor si vive en Argentina")

    if (persona1.esMayor(::mayorEstadosUnidos))
        println("${persona1.nombre} es mayor si vive en Estados Unidos")
    else
        println("${persona1.nombre} no es mayor si vive en Estados Unidos")
}