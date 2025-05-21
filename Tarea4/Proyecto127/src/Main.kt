// Se define una clase llamada Dado que recibe un valor inicial al ser creada
class Dado(valor: Int) {

    // Propiedad 'valor' del dado. Se inicializa con 1 como valor por defecto.
    var valor: Int = 1
        set(valor) { // Setter personalizado para validar el valor del dado
            if (valor in 1..6) // Si el valor está entre 1 y 6 (inclusive)
                field = valor // Se asigna normalmente
            else
                field = 1 // Si no es válido (como 0 o 7), se asigna el valor por defecto: 1
        }

    // Bloque de inicialización que se ejecuta al crear un objeto de esta clase
    init {
        this.valor = valor // Se utiliza el setter para validar el valor pasado al constructor
    }

    // Función que "lanza" el dado, generando un número aleatorio entre 1 y 6
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt() // Math.random() genera un número de 0.0 a <1.0
        // Multiplicamos por 6 y sumamos 1 para obtener valores entre 1 y 6
    }

    // Función que imprime el valor actual del dado
    fun imprimir() = println("Valor del dado: $valor")
}

// Función principal
fun main(parametro: Array<String>) {
    val dado1 = Dado(7) // Se intenta crear un dado con valor 7 (inválido), así que se asigna 1
    dado1.imprimir()     // Muestra: Valor del dado: 1

    dado1.tirar()        // Se lanza el dado (asigna un valor aleatorio entre 1 y 6)
    dado1.imprimir()     // Imprime el nuevo valor obtenido
}
