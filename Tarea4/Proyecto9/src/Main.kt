fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'v1'
    val v1 = readln().toInt()

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'v2'
    val v2 = readln().toInt()

    // Solicita al usuario que ingrese el tercer valor
    print("Ingrese tercer valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'v3'
    val v3 = readln().toInt()

    // Solicita al usuario que ingrese el cuarto valor
    print("Ingrese cuarto valor:")
    // Lee la entrada, la convierte a entero y la guarda en 'v4'
    val v4 = readln().toInt()

    // Se calcula la suma de los cuatro valores ingresados
    val suma = v1 + v2 + v3 + v4
    // Se imprime el resultado de la suma
    println("La suma de los cuatro valores es $suma")

    // Se calcula el promedio dividiendo la suma entre 4
    val prom = suma / 4
    // Se imprime el resultado del promedio
    println("El promedio de los cuatro valores es $prom")
}
