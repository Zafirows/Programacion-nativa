// Ejemplo de herencia y sobrescritura de métodos

// Clase base Persona
open class Persona(val nombre: String, val edad: Int) {
    // Método abierto para imprimir los datos
    open fun imprimir() {
        println("Nombre: $nombre")
        println("Edad: $edad")
    }
}

// Clase derivada Empleado que hereda de Persona
class Empleado(nombre: String, edad: Int, val sueldo: Double): Persona(nombre, edad) {
    // Sobrescribe el método imprimir para agregar el sueldo
    override fun imprimir() {
        super.imprimir()
        println("Sueldo: $sueldo")
    }

    // Método que determina si el empleado paga impuestos
    fun pagaImpuestos() {
        if (sueldo > 3000)
            println("El empleado $nombre paga impuestos")
        else
            println("El empleado $nombre no paga impuestos")
    }
}

// Función principal
fun main(parametro: Array<String>) {
    val persona1 = Persona("Jose", 22)
    println("Datos de la persona")
    persona1.imprimir()

    val empleado1 = Empleado("Ana", 30, 5000.0)
    println("Datos del empleado")
    empleado1.imprimir()
    empleado1.pagaImpuestos()
}