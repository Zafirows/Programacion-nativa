// Data class Persona con método toString personalizado
data class Persona(var nombre: String, var edad: Int) {
    override fun toString(): String {
        return "$nombre, $edad"
    }
}

fun main(parametro: Array<String>) {
    val persona1 = Persona("Juan", 22)
    val persona2 = Persona("Ana", 59)
    println(persona1)
    println(persona2)
}