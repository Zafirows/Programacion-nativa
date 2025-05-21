fun main(parametro: Array<String>) {
    // Se crean dos arreglos de 4 enteros cada uno
    val arreglo1 = IntArray(4)
    val arreglo2 = IntArray(4)

    println("Carga del primer arreglo")
    // Se llena el primer arreglo con valores ingresados por el usuario
    for(i in arreglo1.indices) {
        print("Ingrese elemento: ")
        arreglo1[i] = readln().toInt()  // Se convierte la entrada a entero
    }

    println("Carga del segundo arreglo")
    // Se llena el segundo arreglo con valores ingresados por el usuario
    for(i in arreglo2.indices) {
        print("Ingrese elemento: ")
        arreglo2[i] = readln().toInt()
    }

    // Se crea un tercer arreglo para guardar la suma de los otros dos
    val arregloSuma = IntArray(4)

    // Se suman los elementos en la misma posición de ambos arreglos
    for(i in arregloSuma.indices)
        arregloSuma[i] = arreglo1[i] + arreglo2[i]

    // Se imprime el arreglo resultante
    println("Arreglo resultante")
    for(elemento in arregloSuma)
        println(elemento)
}
