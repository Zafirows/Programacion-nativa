// Clase Dados con operador invoke para acceder a valores como si fueran función
class Dados {
    val arreglo = IntArray(10)

    fun tirar() {
        for (i in arreglo.indices)
            arreglo[i] = ((Math.random() * 6) + 1).toInt()
    }

    // Permite invocar al objeto como si fuera función: dados(0)
    operator fun invoke(nro: Int) = arreglo[nro]
}

fun main(args: Array<String>) {
    val dados = Dados()
    dados.tirar()
    println(dados(0))
    println(dados(1))
    for (i in 2..9)
        println(dados(i))
}