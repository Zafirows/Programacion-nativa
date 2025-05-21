fun main(parametro: Array<String>) {
    // Solicitar al usuario las coordenadas x y y
    print("Ingrese coordenada x:")
    val x = readln().toInt()  // Leer la coordenada x y convertirla a entero

    print("Ingrese coordenada y:")
    val y = readln().toInt()  // Leer la coordenada y y convertirla a entero

    // Verificar en qué cuadrante se encuentra el punto (x, y)
    if (x > 0 && y > 0)  // Primer cuadrante: x y ambos positivos
        print("Se encuentra en el primer cuadrante")
    else
        if (x < 0 && y > 0)  // Segundo cuadrante: x negativo, y positivo
            print("Se encuentra en el segundo cuadrante")
        else
            if (x < 0 && y < 0)  // Tercer cuadrante: x y ambos negativos
                print("Se encuentra en el tercer cuadrante")
            else
                if (x > 0 && y < 0)  // Cuarto cuadrante: x positivo, y negativo
                    print("Se encuentra en el cuarto cuadrante")
                else  // Si no está en ningún cuadrante, debe estar en un eje (x = 0 o y = 0)
                    print("Se encuentra en un eje")
}
