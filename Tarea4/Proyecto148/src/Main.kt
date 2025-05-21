// Se define una clase llamada Persona con dos propiedades: nombre (String) y edad (Int).
class Persona(val nombre: String, val edad: Int) {

    // Método 'esMayor' que recibe como parámetro una función (lambda o referencia) que toma un Int y devuelve un Boolean.
    // La función se aplica a la edad de la persona.
    fun esMayor(fn: (Int) -> Boolean): Boolean {
        return fn(edad) // Se evalúa la función pasando la edad de la persona
    }
}
// Función que determina si alguien es mayor en Estados Unidos (21 años o más)
fun mayorEstadosUnidos(edad: Int): Boolean {
    if (edad >= 21)
        return true
    else
        return false
}

// Función que determina si alguien es mayor en Argentina (18 años o más)
fun mayorArgentina(edad: Int): Boolean {
    if (edad >= 18)
        return true
    else
        return false
}
fun main(parametro: Array<String>) {
    // Se crea una instancia de Persona con nombre "juan" y edad 18
    val persona1 = Persona("juan", 18)

    // Se evalúa si la persona es mayor en Argentina, usando la función como parámetro
    if (persona1.esMayor(::mayorArgentina))
        println("${persona1.nombre} es mayor si vive en Argentina")
    else
        println("${persona1.nombre} no es mayor si vive en Argentina")

    // Se evalúa si la persona es mayor en Estados Unidos
    if (persona1.esMayor(::mayorEstadosUnidos))
        println("${persona1.nombre} es mayor si vive en Estados Unidos")
    else
        println("${persona1.nombre} no es mayor si vive en Estados Unidos")
}
