// Función que recibe el valor de un lado de un cuadrado y retorna su perímetro.
// El perímetro de un cuadrado es 4 veces el valor de un lado.
fun retornarPerimetro(lado: Int) = lado * 4

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el valor de un lado del cuadrado.
    print("Ingrese el lado del cuadrado:")

    // Lee la entrada del usuario desde la consola y la convierte a un número entero (Int).
    val lado = readln().toInt()

    // Llama a la función 'retornarPerimetro' pasándole el lado ingresado y muestra el resultado.
    // El resultado se incrusta directamente dentro del texto usando ${...}
    print("El perimetro es: ${retornarPerimetro(lado)}")
}
