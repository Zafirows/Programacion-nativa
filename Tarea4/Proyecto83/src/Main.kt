// Función que recibe un parámetro 'lado' de tipo Int y devuelve el perímetro del cuadrado
fun retornarPerimetro(lado: Int): Int {
    // Calcula el perímetro del cuadrado, multiplicando el lado por 4 (porque un cuadrado tiene 4 lados iguales)
    val perimetro = lado * 4

    // Devuelve el valor calculado del perímetro
    return perimetro
}

fun main(parametro: Array<String>) {
    // Pide al usuario que ingrese el valor del lado del cuadrado
    print("Ingrese el lado del cuadrado:")

    // Lee el valor ingresado por el usuario y lo convierte a un entero (Int)
    val lado = readln().toInt()

    // Llama a la función retornarPerimetro pasándole el valor del lado, y luego imprime el resultado
    // Muestra el perímetro del cuadrado en la consola
    print("El perimetro es: ${retornarPerimetro(lado)}")
}
