
/*
fun main() {
    val favoriteActor = null 
    println(favoriteActor)
}
*/


// Este bloque muestra cómo declarar una variable nullable usando el signo de interrogación (?).
// Se imprime un valor no nulo y luego null.
/*
fun main() {
    var favoriteActor: String? = "Sandra Oh" // Variable que puede ser null
    println(favoriteActor) // Imprime: Sandra Oh

    favoriteActor = null
    println(favoriteActor) // Imprime: null
}
*/


// Igual que el anterior, pero con un número (tipo Int?) en vez de String.
/*
fun main() {
    var number: Int? = 10
    println(number) // Imprime: 10

    number = null
    println(number) // Imprime: null
}
*/


// Aquí se usa una variable no nullable.
// Se accede directamente a su propiedad `.length` sin problemas.
/*
fun main() {
    var favoriteActor: String = "Sandra Oh"
    println(favoriteActor.length) // Imprime: 9
}
*/


// Aquí la variable es nullable. Para evitar error se usa el operador seguro `?.`.
// Si `favoriteActor` es null, el resultado de `favoriteActor?.length` será null.
/*
fun main() {
    var favoriteActor: String? = null
    println(favoriteActor?.length) // Imprime: null
}
*/


// En este caso se usa el operador `!!` que **fuerza** el acceso al valor, aunque sea null.
// Esto lanza una excepción (`NullPointerException`) si `favoriteActor` es null.
/*
fun main() {
    var favoriteActor: String? = null
    println(favoriteActor!!.length) // Lanzará NullPointerException
}
*/


// Uso de verificación antes de acceder al valor.
// Se asegura que no sea null antes de usar `.length`.
/*
fun main() {
    var favoriteActor: String? = "Sandra Oh"

    if (favoriteActor != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
        // Imprime: The number of characters in your favorite actor's name is 9.
    }
}
*/


// Igual que el anterior pero agrega un `else` para cuando el valor es null.
/*
fun main() {
    var favoriteActor: String? = null

    if(favoriteActor != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    } else {
        println("You didn't input a name.") // Imprime esto si es null
    }
}
*/


// Usa una expresión if para calcular la longitud si no es null, y 0 si lo es.
/*
fun main() {
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = if (favoriteActor != null) {
        favoriteActor.length
    } else {
        0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")
    // Imprime: 9
}
*/


//  Código activo: usa el operador Elvis `?:` para asignar 0 si el valor es null.
// Esta es una forma muy concisa y segura de trabajar con nullables.
fun main() {
    var favoriteActor: String? = "Sandra Oh"

    // Si favoriteActor no es null, toma su longitud; si es null, usa 0
    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")
    // Imprime: 9
}

