fun main(parametro: Array<String>) {
    var cantidad = 0 // Contador para los triángulos cuya superficie sea mayor a 12

    print("Cuantos triángulos procesará:")
    val n = readln().toInt() // El usuario indica cuántos triángulos quiere analizar

    for(i in 1..n) {
        // Por cada triángulo se pide la base y la altura
        print("Ingrese el valor de la base:")
        val base = readln().toInt()

        print("Ingrese el valor de la altura:")
        val altura = readln().toInt()

        // Se calcula la superficie del triángulo usando la fórmula: base * altura / 2
        val superficie = base * altura / 2
        println("La superficie es de $superficie")

        // Si la superficie es mayor a 12, se incrementa el contador
        if (superficie > 12)
            cantidad++
    }

    // Al finalizar el ciclo, se muestra cuántos triángulos superaron la superficie de 12
    print("La cantidad de triángulos con superficie superior a 12 son: $cantidad")
}
