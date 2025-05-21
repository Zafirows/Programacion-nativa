// Se define una clase llamada Hijos
class Hijos {
    // Se crea un arreglo de 5 enteros para guardar las edades de los hijos
    val edades = IntArray(5)

    // Función que permite cargar las edades desde la entrada del usuario
    fun cargar() {
        for(i in edades.indices) { // Recorre cada posición del arreglo
            print("Ingrese edad: ")
            edades[i] = readln().toInt() // Lee y guarda la edad ingresada por el usuario
        }
        // Llama a las funciones que procesan la información
        mayorEdad()
        promedio()
    }

    // Función que encuentra y muestra la mayor edad del arreglo
    fun mayorEdad() {
        var mayor = edades[0] // Se asume inicialmente que la primera edad es la mayor
        for(i in edades.indices)
            if (edades[i] > mayor)
                mayor = edades[i] // Se actualiza si se encuentra una edad mayor
        println("El hijo con mayor edad tiene $mayor años")
    }

    // Función que calcula y muestra el promedio de las edades
    fun promedio() {
        var suma = 0
        for(i in edades.indices)
            suma += edades[i] // Suma todas las edades
        val promedio = suma / edades.size // Divide por el total de hijos (5)
        println("La edad promedio de los hijos es $promedio")
    }
}
// Función principal del programa
fun main(parametros: Array<String>) {
    // Se crea una instancia de la clase Hijos
    val hijos1 = Hijos()

    // Se llama a la función cargar para ingresar y procesar las edades
    hijos1.cargar()
}
