//CAPITULO 17 -Fundamentos de Kotlin (Completo)
// Definimos una función llamada 'demo' que recibe un parámetro 'x' de tipo Any.
// 'Any' es el tipo base en Kotlin, puede representar cualquier tipo de dato (String, Int, etc.).
fun demo(x: Any) {

    // Usamos una estructura 'if' con el operador 'is' para verificar si 'x' es de tipo String.
    if (x is String) {

        // Dentro de este bloque, Kotlin automáticamente convierte (castea) 'x' a tipo String.
        // Por eso podemos acceder directamente a propiedades de String, como 'length'.
        println(x.length)
    }
}
