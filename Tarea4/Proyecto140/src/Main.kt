// Ejemplo de clase abstracta y herencia para operaciones matemáticas

// Clase abstracta que define una operación
abstract class Operacion(val valor1: Int, val valor2: Int) {
    protected var resultado: Int = 0

    abstract fun operar()

    fun imprimir() {
        println("Resultado: $resultado")
    }
}

// Clase Suma que implementa la operación
class Suma(valor1: Int, valor2: Int): Operacion(valor1, valor2) {
    override fun operar() {
        resultado = valor1 + valor2
    }
}

// Clase Resta que implementa la operación
class Resta(valor1: Int, valor2: Int): Operacion(valor1, valor2) {
    override fun operar() {
        resultado = valor1 - valor2
    }
}

// Función principal
fun main(parametro: Array<String>) {
    val suma1 = Suma(10, 4)
    suma1.operar()
    suma1.imprimir()

    val resta1 = Resta(20, 5)
    resta1.operar()
    resta1.imprimir()
}