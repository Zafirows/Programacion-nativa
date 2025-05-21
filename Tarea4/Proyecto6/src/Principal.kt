fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese la medida de un lado del cuadrado
    print("Ingrese la medida del lado del cuadrado:")

    // Lee la entrada desde el teclado, la convierte a entero y la guarda en 'lado'
    val lado = readln().toInt()

    // Calcula el perímetro del cuadrado multiplicando el lado por 4
    val perimetro = lado * 4

    // Muestra el resultado del perímetro en pantalla
    println("El perímetro del cuadrado es $perimetro")
}
