// Función para pedir al usuario que ingrese una altura (valor tipo Float)
fun cargar(): Float {
    print("Ingrese la altura de la persona (Ej. 1.92): ")
    val valor = readln().toFloat()  // Lee la entrada del usuario y la convierte a Float
    return valor  // Retorna la altura ingresada
}

fun main(args: Array<String>) {
    // Creamos una lista de 5 alturas, llamando a la función cargar() 5 veces
    val lista1: List<Float> = List(5) { cargar() }

    // Calculamos la altura promedio con la función average()
    val promedio = lista1.average()
    println("La altura promedio de las personas es $promedio")

    // Contamos cuántas alturas son mayores al promedio
    val altos = lista1.count { it > promedio }

    // Contamos cuántas alturas son menores al promedio
    val bajos = lista1.count { it < promedio }

    // Mostramos la cantidad de personas más altas y más bajas que el promedio
    println("La cantidad de personas más altas al promedio es: $altos")
    println("La cantidad de personas más bajas al promedio es: $bajos")
}
