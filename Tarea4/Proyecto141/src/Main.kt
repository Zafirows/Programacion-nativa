// Clase abstracta base llamada Cuenta
// No se puede instanciar directamente, solo a través de sus subclases.
abstract class Cuenta(val titular: String, val monto: Double) {

    // Método que puede ser sobrescrito en las subclases.
    open fun imprimir() {
        println("Titular: $titular")
        println("Monto: $monto")
    }
}
// Subclase llamada CajaAhorro que hereda de Cuenta.
class CajaAhorro(titular: String, monto: Double): Cuenta(titular, monto) {

    // Sobrescribe el método imprimir para mostrar un mensaje adicional.
    override fun imprimir() {
        println("Cuenta de caja de ahorro")
        super.imprimir()  // Llama al método imprimir de la clase base
    }
}
// Subclase llamada PlazoFijo que también hereda de Cuenta.
// Además, tiene atributos adicionales: plazo (en días) e interes (porcentaje).
class PlazoFijo(titular: String, monto: Double, val plazo: Int, val interes: Double): Cuenta(titular, monto) {

    // Sobrescribe el método imprimir para mostrar más detalles específicos.
    override fun imprimir() {
        println("Cuenta de plazo fijo")
        println("Plazo en días: $plazo")
        println("Intereses: $interes")

        // Calcula la ganancia en base al monto e interés.
        val ganancia = monto * interes / 100
        println("Importe del interés: $ganancia")

        super.imprimir()  // Llama a la función imprimir de la clase padre
    }
}
// Función principal donde se crean e imprimen las cuentas
fun main(parametro: Array<String>) {

    // Se crea un objeto de tipo CajaAhorro
    val cajaAhorro1 = CajaAhorro("juan", 10000.0)
    cajaAhorro1.imprimir()

    // Se crea un objeto de tipo PlazoFijo
    val plazoFijo1 = PlazoFijo("Ana", 5000.0, 30, 1.23)
    plazoFijo1.imprimir()
}
