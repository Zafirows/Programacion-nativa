// Función que recibe un número variable de argumentos enteros (`vararg`) llamados `edades`
// y retorna la cantidad de elementos mayores o iguales a 18.
fun cantidadMayores(vararg edades: Int) = edades.count { it >= 18 }
fun main(args: Array<String>) =
    println(cantidadMayores(3, 65, 32, 23, 2, 98, 23, 45, 15))
