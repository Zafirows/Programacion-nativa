// Clase que representa a un socio del club con nombre y antigüedad (años)
class Socio(val nombre: String, val antiguedad: Int) {
    // Método para imprimir la información del socio
    fun imprimir() {
        println("$nombre tiene una antiguedad de $antiguedad años")
    }
}

// Clase que representa un club con tres socios fijos
class Club {
    // Se crean tres objetos socio con datos predeterminados
    val socio1 = Socio("Juan", 22)
    val socio2 = Socio("Ana", 34)
    val socio3 = Socio("Carlos", 1)

    // Función que muestra los socios y determina quién tiene la mayor antigüedad
    fun mayorAntiguedad() {
        // Imprime los datos de cada socio
        socio1.imprimir()
        socio2.imprimir()
        socio3.imprimir()

        // Imprime el encabezado para el socio con mayor antigüedad
        print("Socio con mayor antiguedad: ")

        // Evalúa cuál socio tiene la mayor antigüedad usando condiciones
        when {
            socio1.antiguedad > socio2.antiguedad && socio1.antiguedad > socio3.antiguedad -> print(socio1.nombre)
            socio2.antiguedad > socio3.antiguedad -> print(socio2.nombre)
            else -> print(socio3.nombre)
        }
    }
}

// Función principal que inicia el programa
fun main(parametro: Array<String>) {
    // Se crea un objeto club con los tres socios
    val club1 = Club()

    // Se llama a la función que muestra el socio con mayor antigüedad
    club1.mayorAntiguedad()
}
