// Uso de enum class para representar tipos de cartas
enum class TipoCarta {
    DIAMANTE,
    TREBOL,
    CORAZON,
    PICA
}

// Clase Carta que imprime su tipo y valor
class Carta(val tipo: TipoCarta, val valor: Int) {
    fun imprimir() {
        println("Carta: $tipo y su valor es $valor")
    }
}

fun main(parametro: Array<String>) {
    val carta1 = Carta(TipoCarta.TREBOL, 4)
    carta1.imprimir()
}