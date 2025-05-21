// Clase base abierta llamada Dado.
// La palabra `open` permite que otras clases hereden de ella.
open class Dado {
    // Propiedad protegida, accesible desde esta clase y sus subclases.
    protected var valor: Int = 1

    // Método que genera un número aleatorio entre 1 y 6 para simular una tirada de dado.
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Método que imprime el valor del dado. Es `open` para que pueda ser sobrescrito en subclases.
    open fun imprimir() {
        println("$valor")
    }
}
// Subclase que hereda de Dado.
// Sobrescribe el método `imprimir` para mostrar el valor con un marco o recuadro.
class DadoRecuadro: Dado() {
    // Sobrescribe el método imprimir para mostrar el valor entre líneas de asteriscos.
    override fun imprimir() {
        println("***")
        println("*$valor*")  // Accede a `valor` porque es `protected`.
        println("***")
    }
}
// Función principal donde se crean e imprimen dos dados.
fun main(parametro: Array<String>) {
    val dado1 = Dado()       // Se crea un objeto de la clase base Dado
    dado1.tirar()            // Se genera un valor aleatorio
    dado1.imprimir()         // Se imprime solo el valor, por ejemplo: 3

    val dado2 = DadoRecuadro()  // Se crea un objeto de la subclase DadoRecuadro
    dado2.tirar()               // Se genera un valor aleatorio
    dado2.imprimir()            // Se imprime el valor en forma de recuadro:
    // ***
    // *4*
    // ***
}
