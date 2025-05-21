// Se define la clase Dado
class Dado (var valor: Int = 1) {

    // Método para tirar el dado, genera un valor aleatorio entre 1 y 6
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()  // Math.random() devuelve un número entre 0.0 y 1.0
    }

    // Método para imprimir el valor del dado
    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

fun main(parametro: Array<String>) {
    // Se crea un arreglo con 5 objetos Dado
    var dados: Array<Dado> = arrayOf(Dado(), Dado(), Dado(), Dado(), Dado())

    // Se tiran los 5 dados (se les asigna un valor aleatorio del 1 al 6)
    for(dado in dados)
        dado.tirar()

    // Se imprime el valor de cada dado
    for(dado in dados)
        dado.imprimir()

    // Variables contadoras para cada posible resultado del dado
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0
    var cant4 = 0
    var cant5 = 0
    var cant6 = 0

    // Se recorre cada dado y se incrementa el contador correspondiente según su valor
    dados.forEach {
        when (it.valor) {
            1 -> cant1++
            2 -> cant2++
            3 -> cant3++
            4 -> cant4++
            5 -> cant5++
            6 -> cant6++
        }
    }

    // Se imprime cuántas veces salió cada valor del dado
    println("Cantidad de dados que tienen el valor 1: $cant1")
    println("Cantidad de dados que tienen el valor 2: $cant2")
    println("Cantidad de dados que tienen el valor 3: $cant3")
    println("Cantidad de dados que tienen el valor 4: $cant4")
    println("Cantidad de dados que tienen el valor 5: $cant5")
    println("Cantidad de dados que tienen el valor 6: $cant6")
}
