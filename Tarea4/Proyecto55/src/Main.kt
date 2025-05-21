fun main(argumento: Array<String>) {
    print("Ingrese un valor entre 1 y 10:")
    val valor = readln().toInt() // Se lee el número ingresado por el usuario

    for(i in valor..valor * 12 step valor) // Se recorre desde ese valor hasta su múltiplo 12, aumentando de "valor" en "valor"
        println(i) // Se imprime cada múltiplo
}
