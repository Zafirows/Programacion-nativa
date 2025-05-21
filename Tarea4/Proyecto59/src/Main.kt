fun main(parametro: Array<String>) {
    // Solicita coordenada x
    print("Ingrese coordenada x del punto:")
    val x = readln().toInt()

    // Solicita coordenada y
    print("Ingrese coordenada y del punto:")
    val y = readln().toInt()

    // Estructura condicional usando 'when'
    when {
        x > 0 && y > 0 -> println("Primer cuadrante")
        x < 0 && y > 0 -> println("Segundo cuadrante")
        x < 0 && y < 0 -> println("Tercer cuadrante")
        x > 0 && y < 0 -> println("Cuarto cuadrante")
        else -> println("El punto se encuentra en un eje") // Si x=0 o y=0
    }
}
