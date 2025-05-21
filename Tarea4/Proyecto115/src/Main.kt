// Se define una clase llamada Alumno con dos propiedades que se reciben por el constructor
class Alumno(val nombre: String, val nota: Int) {

    // Método para imprimir el nombre y la nota del alumno
    fun imprimir() {
        println("Alumno: $nombre tiene una nota de $nota")
    }

    // Método para mostrar si el alumno está en estado REGULAR (nota >= 4)
    fun mostrarEstado () {
        if (nota >= 4)
            println("$nombre se encuentra en estado REGULAR")
        else
            println("$nombre no está REGULAR")
    }
}
// Función principal del programa
fun main(parametros: Array<String>) {
    // Se crea un objeto Alumno llamado "alumno1" usando el constructor con datos fijos
    val alumno1 = Alumno("Ana", 7)
    alumno1.imprimir()         // Se imprime su información
    alumno1.mostrarEstado()    // Se indica si está REGULAR

    // Se crea otro objeto Alumno llamado "alumno2"
    val alumno2 = Alumno("Carlos", 2)
    alumno2.imprimir()
    alumno2.mostrarEstado()
}
