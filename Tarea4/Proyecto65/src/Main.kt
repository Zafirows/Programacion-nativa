fun main(argumento: Array<String>) {
    // Variables contadoras para cada tipo de triángulo
    var cant1 = 0 // Equiláteros
    var cant2 = 0 // Isósceles
    var cant3 = 0 // Escalenos

    // Solicita al usuario cuántos triángulos quiere ingresar
    print("Ingrese la cantidad de triángulos:")
    val n = readln().toInt()

    // Bucle que se repite 'n' veces (una vez por cada triángulo)
    for(i in 1..n) {
        // Solicita los tres lados del triángulo
        print("Ingrese lado 1:")
        val lado1 = readln().toInt()
        print("Ingrese lado 2:")
        val lado2 = readln().toInt()
        print("Ingrese lado 3:")
        val lado3 = readln().toInt()

        // Clasifica el tipo de triángulo según los lados ingresados
        when {
            // Si los tres lados son iguales, es equilátero
            lado1 == lado2 && lado1 == lado3 -> {
                println("Es un triángulo equilatero.")
                cant1++ // Aumenta el contador de equiláteros
            }
            // Si dos lados son iguales, es isósceles
            lado1 == lado2 || lado1 == lado3 || lado2 == lado3 -> {
                println("Es un triángulo isósceles.")
                cant2++ // Aumenta el contador de isósceles
            }
            // Si todos los lados son distintos, es escaleno
            else -> {
                println("Es un triángulo escaleno.")
                cant3++ // Aumenta el contador de escalenos
            }
        }
    }

    // Imprime la cantidad total de cada tipo de triángulo
    println("Cantidad de triángulos equilateros: $cant1")
    println("Cantidad de triángulos isósceles: $cant2")
    println("Cantidad de triángulos escalenos: $cant3")
}
