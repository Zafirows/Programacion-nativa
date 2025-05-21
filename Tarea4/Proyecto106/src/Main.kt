// Carga una cantidad variable de sueldos en un arreglo y los imprime
fun cargar(): IntArray {
    print("Cuantos sueldos quiere cargar:")
    val cantidad = readLine()!!.toInt()
    val sueldos = IntArray(cantidad)
    for(i in sueldos.indices) {
        print("Ingrese elemento:")
        sueldos[i] = readLine()!!.toInt()
    }
    return sueldos
}
fun imprimir(sueldos: IntArray) {
    println("Listado de todos los sueldos")
    for(sueldo in sueldos)
        println(sueldo)
}
fun main(parametro: Array<String>) {
    val sueldos = cargar()
    imprimir(sueldos)
}