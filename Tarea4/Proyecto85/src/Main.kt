// Función que devuelve la superficie de un cuadrado.
// Usamos la expresión de función de una sola línea (función de expresión) que calcula el área.
fun retornarSuperficie(lado: Int) = lado * lado

fun main(parametro: Array<String>) {
    // Imprime el mensaje solicitando al usuario que ingrese el valor del lado del cuadrado
    print("Ingrese el valor del lado del cuadrado:")

    // Lee la entrada del usuario, la convierte a un entero y la guarda en la variable 'la'
    val la = readln().toInt()

    // Imprime el resultado, llamando a la función 'retornarSuperficie' con el valor de 'la'
    // El resultado es calculado y mostrado en la misma línea con el uso de la interpolación de cadenas
    println("La superficie del cuadrado es ${retornarSuperficie(la)}")
}
