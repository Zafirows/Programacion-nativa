/*
fun main() {
    // Arrays de planetas rocosos y gaseosos
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Little Earth")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    // Nuevo arreglo que contiene todos los planetas, incluyendo Plutón
    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

    // Concatenación de arreglos de planetas rocosos y gaseosos
    val solarSystem = rockPlanets + gasPlanets

    // Imprime cada planeta por índice
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])
    println(newSolarSystem[8]) // Plutón
}
*/

/*
fun main() {
    // Lista inmutable de planetas del sistema solar
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println(solarSystem.size)         // Imprime el tamaño de la lista
    println(solarSystem[2])           // Acceso al tercer planeta (Earth)
    println(solarSystem.get(3))       // Acceso al cuarto planeta (Mars) usando get()
    println(solarSystem.indexOf("Earth"))  // Busca el índice de Earth
    println(solarSystem.indexOf("Pluto"))  // Busca el índice de Pluto (no existe, devuelve -1)

    // Itera y imprime todos los planetas
    for (planet in solarSystem) {
        println(planet)
    }
}
*/

/*
fun main() {
    // Lista mutable de planetas, se puede modificar
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    solarSystem.add("Pluto")          // Agrega Plutón al final
    solarSystem.add(3, "Future Moon") // Inserta "Future Moon" en la posición 3

    println(solarSystem[3])  // Imprime "Future Moon"
    println(solarSystem[9])  // Imprime "Pluto"
}
*/

/*
fun main() {
    // Lista mutable de planetas
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    solarSystem.add("Pluto")          // Agrega Plutón
    solarSystem.add(3, "Future Moon") // Inserta "Future Moon"
    solarSystem.removeAt(9)            // Elimina el elemento en la posición 9 ("Pluto")
    solarSystem.remove("Future Moon") // Elimina "Future Moon"

    println(solarSystem.contains("Pluto"))     // Verifica si Plutón está en la lista (false)
    println("Future Moon" in solarSystem)      // Verifica si "Future Moon" está en la lista (false)
}
*/

/*
fun main() {
    // Conjunto mutable (Set) de planetas — no permite duplicados
    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println(solarSystem.size)       // Tamaño inicial
    solarSystem.add("Pluto")        // Agrega Plutón
    println(solarSystem.size)       // Tamaño después de agregar Plutón
    println(solarSystem.contains("Pluto"))  // Verifica si Plutón está en el conjunto
    solarSystem.add("Pluto")        // Intenta agregar Plutón otra vez (no se duplica)
    println(solarSystem.size)       // Tamaño permanece igual
    solarSystem.remove("Pluto")     // Elimina Plutón
    println(solarSystem.size)       // Tamaño después de eliminar
    println(solarSystem.contains("Pluto"))  // Verifica si Plutón está (false)
}
*/

fun main() {
    // Mapa mutable que asocia planetas con número de lunas
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem.size)        // Número de entradas en el mapa
    solarSystem["Pluto"] = 5         // Añade Plutón con 5 lunas
    println(solarSystem.size)        // Tamaño actualizado
    println(solarSystem["Pluto"])    // Imprime número de lunas de Plutón
    println(solarSystem.get("Theia"))// Intenta obtener valor para "Theia" (no existe, imprime null)
    solarSystem.remove("Pluto")      // Elimina Plutón del mapa
    println(solarSystem.size)        // Tamaño después de eliminar Plutón
    solarSystem["Jupiter"] = 78      // Actualiza el número de lunas de Júpiter
    println(solarSystem["Jupiter"])  // Imprime el nuevo número de lunas de Júpiter
}
