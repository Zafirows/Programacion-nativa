// Se define una clase llamada Empleado que recibe dos parámetros: nombre y sueldo
class Empleado(var nombre: String, sueldo: Double) {

    // Se declara una propiedad 'sueldo' que va a tener lógica personalizada para establecer su valor
    var sueldo: Double = 0.0
        set(valor) { // Este es el "setter" del sueldo
            if (valor < 0) // Si se intenta asignar un sueldo negativo
                field = 0.0 // Se asigna 0.0 por defecto (no se permite sueldo negativo)
            else
                field = valor // Si el sueldo es válido, se asigna normalmente
        }

    // Bloque de inicialización que se ejecuta cuando se crea un objeto de la clase
    init {
        this.sueldo = sueldo // Llama al setter para asignar el sueldo (verifica si es válido o no)
    }

    // Método que imprime el nombre y el sueldo del empleado
    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Se crea un objeto 'empleado1' con un sueldo válido
    val empleado1 = Empleado("Juan", 12000.50)
    empleado1.imprimir() // Imprime: Juan tiene un sueldo de 12000.5

    // Se crea un objeto 'empleado2' con un sueldo negativo
    val empleado2 = Empleado("Ana", -1200.0)
    empleado2.imprimir() // Imprime: Ana tiene un sueldo de 0.0 (porque el setter lo corrigió)
}
