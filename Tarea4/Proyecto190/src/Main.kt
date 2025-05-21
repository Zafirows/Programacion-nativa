// Archivo con funciones y uso en el mismo archivo (sin paquete separado)

fun sumar(valor1: Int, valor2: Int) = valor1 + valor2
fun restar(valor1: Int, valor2: Int) = valor1 - valor2

fun main(args: Array<String>) {
    val su = sumar(5, 7)
    println("La suma es $su")

    val re = restar(10, 3)
    println("La resta es $re")
}