// Importamos las librerías necesarias para trabajar con corrutinas y retardos
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    // Iniciamos una corrutina en el ámbito global (GlobalScope)
    GlobalScope.launch {
        // Imprime los números del 1 al 10, con una pausa de 1 segundo entre cada número
        for (x in 1..10) {
            print("$x ")     // Imprime el número actual
            delay(1000)      // Suspende la corrutina durante 1000 milisegundos (1 segundo)
        }
    }

    // Iniciamos otra corrutina simultáneamente
    GlobalScope.launch {
        // Imprime los números del 11 al 20, también con 1 segundo de pausa entre cada uno
        for (x in 11..20) {
            print("$x ")     // Imprime el número actual
            delay(1000)      // Suspende esta corrutina por 1 segundo
        }
    }

    // Esta línea mantiene el programa en ejecución hasta que el usuario presione Enter
    // Si no estuviera, el programa terminaría antes de que las corrutinas completen su ejecución
    readLine()
}
