// Carga 10 elementos en un arreglo e imprime todos sus valores
fun main(parametro: Array<String>) {
    val arreglo = IntArray(10)
    for(i in arreglo.indices) {
        print("Ingrese elemento:")
        arreglo[i] = readLine()!!.toInt()
    }
    for(elemento in arreglo)
        println(elemento)
}