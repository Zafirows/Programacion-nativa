fun main(parametro: Array<String>) {
    var pares = 0                      // Contador de números pares
    var impares = 0                   // Contador de números impares

    print("Cuantos números ingresará:")
    val n = readln().toInt()         // El usuario indica cuántos números va a ingresar

    var x = 1                         // Contador de iteraciones (empezamos en 1)

    // Bucle que se repite hasta que se ingresen n números
    while (x <= n) {
        print("Ingrese el valor:")
        val valor = readln().toInt() // El usuario ingresa un número

        if (valor % 2 == 0)          // Verifica si el número es par
            pares = pares + 1        // Si es par, incrementa el contador de pares
        else
            impares = impares + 1    // Si no, incrementa el contador de impares

        x = x + 1                    // Avanza al siguiente número
    }

    // Muestra los resultados
    println("Cantidad de pares: $pares")
    println("Cantidad de impares: $impares")
}
