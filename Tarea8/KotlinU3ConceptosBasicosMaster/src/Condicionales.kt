// Este bloque imprime si 1 es igual a 1.
// El operador "==" compara si dos valores son iguales.
// Como 1 sí es igual a 1, se imprimiría "true".
/*
fun main() {
    println(1 == 1) // Resultado: true
}
*/

// Este bloque imprime si 1 es menor que 1.
// El operador "<" evalúa si el número de la izquierda es menor que el de la derecha.
// Como 1 NO es menor que 1, se imprimiría "false".
/*
fun main() {
    println(1 < 1) // Resultado: false
}
*/

/*
// Este es el bloque activo que se ejecuta actualmente.
fun main() {
    // Se define una constante con el color del semáforo
    val trafficLightColor = "Red"

    // Si el color es "Red", imprime "Stop"
    if (trafficLightColor == "Red") {
        println("Stop") // Resultado: Stop
    }
}
 */
// Este bloque evalúa si el color del semáforo es "Red".
// Si es "Red", imprime "Stop"; si no, imprime "Go".
// En este caso, como el color es "Red", el resultado sería: Stop
/*
fun main() {
    val trafficLightColor = "Red"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else {
        println("Go")
    }
}
*/

// Este bloque hace lo mismo que el anterior, pero el color es "Green".
// Como "Green" no es "Red", se va al else y se imprime: Go
/*
fun main() {
    val trafficLightColor = "Green"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else {
        println("Go")
    }
}
*/

// En este bloque se agregan más condiciones usando `else if`.
// Si el color es "Red" → "Stop", si es "Yellow" → "Slow", si no, → "Go".
// Aquí el color es "Yellow", así que el resultado sería: Slow
/*
fun main() {
    val trafficLightColor = "Yellow"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else {
        println("Go")
    }
}
*/

// Igual que el anterior, pero con el color "Black".
// No es "Red" ni "Yellow", así que se ejecuta el else final: Go
/*
fun main() {
    val trafficLightColor = "Black"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else {
        println("Go")
    }
}
*/

// En este bloque se controla también el caso "Green" explícitamente.
// Si no es ninguno de los colores válidos, se imprime "Invalid traffic-light color".
// Aquí el color es "Black", que no coincide con ninguna condición, así que el resultado sería: Invalid traffic-light color
/*
fun main() {
    val trafficLightColor = "Black"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
}
 */

// Este bloque usa `when` para actuar según el color del semáforo.
// Si el color es "Red" → "Stop", "Yellow" → "Slow", "Green" → "Go", otro → "Invalid".
// En este caso, el color es "Yellow", así que imprime: Slow
/*
fun main() {
    val trafficLightColor = "Yellow"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
}
*/

// Este bloque usa `when` para determinar si un número es primo.
// Evalúa el valor de `x` y da una respuesta personalizada.
// Como `x = 3`, se imprime: x is a prime number between 1 and 10.
/*
fun main() {
   val x = 3

   when (x) {
       2 -> println("x is a prime number between 1 and 10.")
       3 -> println("x is a prime number between 1 and 10.")
       5 -> println("x is a prime number between 1 and 10.")
       7 -> println("x is a prime number between 1 and 10.")
       else -> println("x isn't a prime number between 1 and 10.")
   }
}
*/

// Versión optimizada del anterior usando varias condiciones en una sola línea.
// Aquí `x = 3`, que está entre los primos, así que se imprime el mismo mensaje.
/*
fun main() {
    val x = 3

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}
*/

// Aquí `x = 4`, que está entre 1 y 10, pero no es primo.
// Se imprime: x is a number between 1 and 10, but not a prime number.
/*
fun main() {
    val x = 4

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}
*/

// Se evalúa el tipo y valor de `x`, que es un `Int` con valor 20.
// No es un primo ni está entre 1 y 10, pero es un `Int`, así que imprime:
// x is an integer number, but not between 1 and 10.
/*
fun main() {
    val x: Any = 20

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        is Int -> println("x is an integer number, but not between 1 and 10.")
        else -> println("x isn't an integer number.")
    }
}
*/

// Aquí se considera que "Amber" y "Yellow" son lo mismo (reducen la velocidad).
// Como el color es "Amber", imprime: Slow
/*
fun main() {
    val trafficLightColor = "Amber"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow", "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
}
*/

// Se usa una expresión `if` para guardar el mensaje en una variable.
// Como el color es "Black", no coincide con ninguno de los colores válidos.
// Resultado: Invalid traffic-light color
/*
fun main() {
    val trafficLightColor = "Black"

    val message =
        if (trafficLightColor == "Red") "Stop"
        else if (trafficLightColor == "Yellow") "Slow"
        else if (trafficLightColor == "Green") "Go"
        else "Invalid traffic-light color"

    println(message)
}
*/

// Código actual: usa `when` como expresión para almacenar el mensaje.
// "Amber" se trata igual que "Yellow", así que imprime: Slow
fun main() {
    val trafficLightColor = "Amber"

    val message = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message)
}
