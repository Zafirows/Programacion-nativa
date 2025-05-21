// Este archivo pertenece al paquete llamado "my.program"
package my.program

// Se define una clase llamada App
class App {

    // companion object es como una forma de definir miembros estáticos en Kotlin
    companion object {

        // La anotación @JvmStatic hace que la función sea accesible como método estático desde Java.
        // También permite que el sistema reconozca esta función como el punto de entrada (main)
        @JvmStatic
        fun main(args: Array<String>) {
            // Imprime el mensaje "Hello World" en la consola
            println("Hello World")
        }
    }
}
