fun main(argumento: Array<String>) {
    var cant1 = 0  // Contador de triángulos equiláteros
    var cant2 = 0  // Contador de triángulos isósceles
    var cant3 = 0  // Contador de triángulos escalenos

    print("Ingrese la cantidad de triángulos:")
    val n = readln().toInt()  // Se lee cuántos triángulos se van a procesar

    for(i in 1..n) {
        // Se ingresan los tres lados del triángulo
        print("Ingrese lado 1:")
        val lado1 = readln().toInt()
        print("Ingrese lado 2:")
        val lado2 = readln().toInt()
        print("Ingrese lado 3:")
        val lado3 = readln().toInt()

        // Clasificación del triángulo según sus lados
        if (lado1 == lado2 && lado1 == lado3) {
            println("Es un triángulo equilatero.") // Todos los lados iguales
            cant1++
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            println("Es un triángulo isósceles.") // Dos lados iguales
            cant2++
        } else {
            println("Es un triángulo escaleno.") // Todos los lados diferentes
            cant3++
        }
    }

    // Se imprimen los resultados finales
    println("Cantidad de triángulos equilateros: $cant1")
    println("Cantidad de triángulos isósceles: $cant2")
    println("Cantidad de triángulos escalenos: $cant3")
}
