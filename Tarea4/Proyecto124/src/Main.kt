// Definimos una clase llamada 'Vector'
class Vector {

    // Se declara un arreglo privado de 5 enteros
    private val vec = IntArray(5)

    // Bloque de inicialización que se ejecuta automáticamente al crear el objeto
    init {
        cargar() // Llama a la función 'cargar' para llenar el arreglo con números aleatorios
    }

    // Función privada que carga el arreglo con números aleatorios del 0 al 10
    private fun cargar() {
        for(i in vec.indices)
            vec[i] = ((Math.random() * 11)).toInt() // Math.random() genera un número entre 0.0 y 1.0, se multiplica por 11 y se convierte a entero
    }

    // Función para imprimir todos los elementos del arreglo
    fun imprimir() {
        println("Listado completo del arreglo")
        for(i in vec.indices)
            print("${vec[i]} - ")
        println() // Salto de línea final
    }

    // Función para encontrar e imprimir el mayor número del arreglo
    fun mostrarMayor() {
        var mayor = vec[0] // Suponemos que el primer elemento es el mayor
        for(i in vec.indices)
            if (vec[i] > mayor)
                mayor = vec[i] // Si encontramos un número mayor, lo actualizamos
        println("El elemento mayor del arreglo es $mayor")
    }

    // Función para encontrar e imprimir el menor número del arreglo
    fun mostrarMenor() {
        var menor = vec[0] // Suponemos que el primer elemento es el menor
        for(i in vec.indices)
            if (vec[i] < menor)
                menor = vec[i] // Si encontramos un número menor, lo actualizamos
        println("El elemento menor del arreglo es $menor")
    }
}

// Función principal donde se ejecuta el programa
fun main(parametro: Array<String>) {
    val vector1 = Vector() // Se crea un objeto de la clase Vector, y se carga automáticamente
    vector1.imprimir()     // Se imprime el contenido del arreglo
    vector1.mostrarMayor() // Se muestra el mayor valor
    vector1.mostrarMenor() // Se muestra el menor valor
}
