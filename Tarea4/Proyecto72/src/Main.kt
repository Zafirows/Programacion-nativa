// Función que calcula el cuadrado de un número
fun calculaCuadrado() {
    print("Ingrese un entero:")                 // Pide al usuario que ingrese un número entero
    val valor = readln().toInt()                // Lee el valor y lo convierte a entero
    val cuadrado = valor * valor                // Calcula el cuadrado del valor ingresado
    println("El cuadrado es $cuadrado")         // Muestra el resultado del cuadrado
}

// Función que calcula el producto de dos valores
fun calcularProducto() {
    print("Ingrese primer valor:")              // Solicita el primer valor al usuario
    val valor1 = readln().toInt()               // Lee el primer valor
    print("Ingrese segundo valor:")             // Solicita el segundo valor
    val valor2 = readln().toInt()               // Lee el segundo valor
    val producto = valor1 * valor2              // Calcula el producto de los dos valores
    println("El producto de los valores es: $producto") // Muestra el resultado del producto
}

// Función principal que llama a las otras dos funciones
fun main(parametro: Array<String>) {
    calculaCuadrado()     // Llama a la función para calcular el cuadrado de un número
    calcularProducto()    // Llama a la función para calcular el producto de dos números
}
