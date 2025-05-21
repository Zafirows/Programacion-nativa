// Uso de enum y argumentos variables en una función para sumar o promediar
enum class Operacion {
    SUMA,
    PROMEDIO
}

fun operar(tipoOperacion: Operacion, vararg arreglo: Int): Int {
    return when (tipoOperacion) {
        Operacion.SUMA -> arreglo.sum()
        Operacion.PROMEDIO -> arreglo.average().toInt()
    }
}

fun main(args: Array<String>) {
    val resultado1 = operar(Operacion.SUMA, 10, 20, 30)
    println("La suma es $resultado1")
    val resultado2 = operar(Operacion.PROMEDIO, 10, 20, 30)
    println("El promedio es $resultado2")
}