// Este archivo pertenece al paquete llamado "my.program"
package my.program

// Se define un objeto llamado App. En Kotlin, 'object' crea un singleton (una única instancia).
object App {

    // La anotación @JvmStatic indica que esta función debe ser tratada como un método 'static' en Java.
    // Esto es útil si quieres que este método sea llamado desde código Java o por el sistema como punto de entrada.
    @JvmStatic
    fun main(args: Array<String>) {
        // Imprime el mensaje "Hello World" en la consola
        println("Hello World")
    }
}
