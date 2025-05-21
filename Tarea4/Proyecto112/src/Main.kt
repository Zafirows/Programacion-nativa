// Clase Persona con constructor y métodos para imprimir y verificar mayoría de edad
class Persona constructor(nombre: String, edad: Int) {
    var nombre: String = nombre
    var edad: Int = edad
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
fun main(parametro: Array<String>) {
    val persona1 = Persona("Juan", 12)
    persona1.imprimir()
    persona1.esMayorEdad()
}