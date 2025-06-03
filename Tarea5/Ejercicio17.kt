//CAPITULO 9 -Declaraciones condicionales
fun main() {
    val str = "Hello!"  // Declara una variable 'str' con el valor "Hello!"

    // Verifica si la longitud de la cadena es 0 (cadena vacía)
    if (str.length == 0) {
        print("Empty string!")  // Si la cadena está vacía, imprime este mensaje
    } 
    // Si no está vacía, verifica si la longitud es mayor que 5
    else if (str.length > 5) {
        print("Long string!")   // Si es mayor que 5, imprime este mensaje
    } 
    // Si no cumple ninguna de las condiciones anteriores
    else {
        print("Short string!")  // Imprime este mensaje para cadenas con longitud entre 1 y 5
    }
}
