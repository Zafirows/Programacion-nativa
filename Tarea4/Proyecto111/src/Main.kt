// Se define una clase llamada Alumno
class Alumno {
    // Atributos de cada objeto Alumno: su nombre y su nota
    var nombre: String = ""
    var nota: Int = 0

    // Método para cargar los datos del alumno desde teclado
    fun inicializar() {
        print("Ingrese el nombre del alumno: ")
        nombre = readln().toString() // Se lee y guarda el nombre

        print("Ingrese su nota: ")
        nota = readln().toInt() // Se lee y guarda la nota como número entero
    }

    // Método para imprimir los datos del alumno
    fun imprimir() {
        println("Alumno: $nombre tiene una nota de $nota")
    }

    // Método para indicar si el alumno está en estado REGULAR
    fun mostrarEstado () {
        // Si la nota es 4 o más, se considera "REGULAR"
        if (nota >= 4)
            println("$nombre se encuentra en estado REGULAR")
        else
            println("$nombre no está REGULAR") // Si no, se considera que no está regular
    }
}

// Función principal del programa
fun main(parametros: Array<String>) {
    // Se crea un primer objeto Alumno
    val alumno1 = Alumno()
    alumno1.inicializar()     // Se piden los datos al usuario
    alumno1.imprimir()        // Se muestran los datos ingresados
    alumno1.mostrarEstado()   // Se muestra si está o no regular

    // Se repite el mismo proceso para un segundo alumno
    val alumno2 = Alumno()
    alumno2.inicializar()
    alumno2.imprimir()
    alumno2.mostrarEstado()
}
