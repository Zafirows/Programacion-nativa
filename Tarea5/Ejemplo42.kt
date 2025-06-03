//CAPITULO 27 -Métodos de extensión
// Función de extensión para String: agrega signos de exclamación al final
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

// Ejemplo de uso:
println("Hola".addEnthusiasm(3)) // Imprime: Hola!!!

// Función de extensión para Int: verifica si el número es par
fun Int.isEven() = this % 2 == 0

// Ejemplo de uso:
println(4.isEven()) // Imprime: true
