// Función que calcula y retorna la superficie de un cuadrado dado su lado
fun retornarSuperficie(lado: Int): Int {
    val sup = lado * lado  // Superficie = lado × lado
    return sup             // Retorna el resultado
}

fun main(parametro: Array<String>) {
    print("Ingrese el valor del lado del cuadrado: ")  // Corrección de 'cuafrado' a 'cuadrado'
    val la = readln().toInt()  // Lee el valor del lado desde teclado

    val superficie = retornarSuperficie(la)  // Llama a la función para calcular la superficie

    println("La superficie del cuadrado es $superficie")  // Muestra el resultado
}
