//CAPITULO 5 -Bucles en kotlin
fun main() {
    // La función repeat(n) ejecuta un bloque de código 'n' veces.
    // En este caso, se repetirá 10 veces.
    repeat(10) { i -> // 'i' es el índice de la iteración (de 0 a 9)
        println("Loop iteration ${i + 1}") // Imprime el número de la iteración (de 1 a 10)
    }
}
