fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el precio de un producto
    print("Ingrese el precio del producto:")

    // Lee la entrada desde el teclado, la convierte a doble (decimal) y la guarda en 'precio'
    val precio = readln().toDouble()

    // Solicita al usuario que ingrese la cantidad de productos que desea comprar
    print("Ingrese la cantidad de productos:")

    // Lee la entrada desde el teclado, la convierte a entero y la guarda en 'cantidad'
    val cantidad = readln().toInt()

    // Calcula el total a pagar multiplicando el precio por la cantidad de productos
    val total = precio * cantidad

    // Muestra el total a pagar en pantalla
    println("El total a pagar es $total")
}
