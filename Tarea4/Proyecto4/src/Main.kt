fun main(argumento: Array<String>) {
    // Se declaran tres variables de tipo Float con los pesos de tres personas
    val peso1 = 89.4f
    val peso2 = 67f
    val peso3 = 87.45f

    // Se calcula el promedio de los tres pesos
    val promedio = (peso1 + peso2 + peso3) / 3

    // Se imprime el promedio de los pesos usando interpolación de cadenas
    println("El promedio de los tres pesos de personas es $promedio")
}
