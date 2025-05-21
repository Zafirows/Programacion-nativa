// Simulación de un juego de dados

// Clase Dado que puede generar un valor aleatorio entre 1 y 6
class Dado (var valor: Int){
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
        imprimir()
    }

    fun imprimir() {
        println("Valor del dado: $valor")
    }
}

// Clase JuegoDeDados que utiliza 3 dados y verifica si todos los valores son iguales
class JuegoDeDados {
    val dado1 = Dado(1)
    val dado2 = Dado(1)
    val dado3 = Dado(1)

    fun jugar() {
        dado1.tirar()
        dado2.tirar()
        dado3.tirar()

        if (dado1.valor == dado2.valor && dado2.valor == dado3.valor)
            println("Ganó")
        else
            print("Perdió")
    }
}

fun main(parametro: Array<String>) {
    val juego1 = JuegoDeDados()
    juego1.jugar()
}