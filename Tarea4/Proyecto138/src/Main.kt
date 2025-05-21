// Herencia con una calculadora básica y una científica

// Clase base Calculadora con operaciones básicas
open class Calculadora(val valor1: Double, val valor2: Double){
    var resultado: Double = 0.0

    fun sumar() { resultado = valor1 + valor2 }
    fun restar() { resultado = valor1 - valor2 }
    fun multiplicar() { resultado = valor1 * valor2 }
    fun dividir() { resultado = valor1 / valor2 }

    fun imprimir() { println("Resultado: $resultado") }
}

// Subclase CalculadoraCientifica con más funciones
class CalculadoraCientifica(valor1: Double, valor2: Double): Calculadora(valor1, valor2) {
    fun cuadrado() {
        resultado = valor1 * valor1
    }

    fun raiz() {
        resultado = Math.sqrt(valor1)
    }
}

// Función principal
fun main(parametro: Array<String>) {
    println("Prueba de la clase Calculadora (suma de dos números)")
    val calculadora1 = Calculadora(10.0, 2.0)
    calculadora1.sumar()
    calculadora1.imprimir()

    println("Prueba de la clase Calculadora Científica")
    val calculadoraCientifica1 = CalculadoraCientifica(10.0, 2.0)
    calculadoraCientifica1.sumar()
    calculadoraCientifica1.imprimir()
    calculadoraCientifica1.cuadrado()
    calculadoraCientifica1.imprimir()
    calculadoraCientifica1.raiz()
    calculadoraCientifica1.imprimir()
}