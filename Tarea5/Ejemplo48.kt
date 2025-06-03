//CAPITULO 31 -Parámetros Vararg
// Define una función llamada 'printAll' que recibe un número variable de argumentos tipo String
fun printAll(vararg messages: String) {
    // Itera sobre cada mensaje recibido y lo imprime
    for (m in messages) println(m)
}

// ---------------- USO ---------------------

// Llama a la función con tres Strings
printAll("Hola", "Mundo", "Kotlin")

// Resultado en consola:
// Hola
// Mundo
// Kotlin
