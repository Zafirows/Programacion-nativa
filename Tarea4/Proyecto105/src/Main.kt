// Carga y muestra los elementos de un arreglo
fun cargar(arreglo: IntArray) {
    for(i in arreglo.indices) {
        print("Ingrese elemento:")
        arreglo[i] = readLine()!!.toInt()
    }
}
fun imprimir(arreglo: IntArray) {
    for(elemento in arreglo)
        println(elemento)
}
fun main(parametro: Array<String>) {
    val arre = IntArray(5)
    cargar(arre)
    imprimir(arre)
}