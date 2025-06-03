/*
fun main() {
    // Se crea una referencia a la función 'trick' usando ::
    // Pero no se llama ni se imprime nada
    val trickFunction = ::trick
}

// Definición de función normal (no lambda)
fun trick() {
    println("No treats!") // Esta línea no se ejecuta en este bloque
}
*/


/*
fun main() {
    // Se asigna la lambda 'trick' a 'trickFunction'
    val trickFunction = trick
    // Se ejecuta la lambda directamente
    trick()
}

// Lambda que imprime un mensaje
val trick = {
    println("No treats!") // Se imprime una vez
}
*/


/*
fun main() {
    // Se asigna la lambda a 'trickFunction'
    val trickFunction = trick
    // Se ejecuta directamente
    trick()
    // Se ejecuta también desde la variable
    trickFunction()
}

// Lambda que imprime un mensaje
val trick = {
    println("No treats!") // Se imprime dos veces
}
*/


/*
val trick = {
    println("No treats!") // Lambda que imprime un truco
}

val treat: () -> Unit = {
    println("Have a treat!") // Lambda que imprime un dulce
}

fun main() {
    val trickFunction = trick
    trick() // Se imprime "No treats!"
    trickFunction() // Se imprime "No treats!" otra vez
    treat() // Se imprime "Have a treat!"
}
*/


/*
fun main() {
    // Se obtiene la función de tipo treat
    val treatFunction = trickOrTreat(false)
    // Se obtiene la función de tipo trick
    val trickFunction = trickOrTreat(true)
    // Se ejecuta la función de tipo treat
    treatFunction() // Imprime "Have a treat!"
    // Se ejecuta la función de tipo trick
    trickFunction() // Imprime "No treats!"
}

// Función que devuelve una lambda dependiendo de isTrick
fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if(isTrick) {
        return trick // Devuelve la lambda trick
    } else {
        return treat // Devuelve la lambda treat
    }
}

// Lambda trick
val trick = {
    println("No treats!")
}

// Lambda treat
val treat: () -> Unit = {
    println("Have a treat!")
}
*/


/*
fun main() {
    // Lambda que convierte un número a texto, como "5 quarters"
    val coins: (Int) -> String = {
        "$it quarters"
    }

    // Se pasa coins como argumento a trickOrTreat
    val treatFunction = trickOrTreat(false, coins) // Se imprime "5 quarters"
    val trickFunction = trickOrTreat(true, null)

    // Ejecuta treatFunction
    treatFunction() // Imprime "Have a treat!"
    // Ejecuta trickFunction
    trickFunction() // Imprime "No treats!"
}

// trickOrTreat recibe un Boolean y una función opcional
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick // Si es truco, devuelve trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5)) // Imprime el resultado de la función coins
        }
        return treat // Devuelve la función treat
    }
}

// Lambda trick
val trick = {
    println("No treats!")
}

// Lambda treat
val treat: () -> Unit = {
    println("Have a treat!")
}
*/


// Bloque final del programa

fun main() {
    // Llama a trickOrTreat con false (no es truco) y una lambda como extraTreat
    val treatFunction = trickOrTreat(false) { "$it quarters" } // Imprime "5 quarters"

    // Llama a trickOrTreat con true (sí es truco) y sin extraTreat
    val trickFunction = trickOrTreat(true, null)

    // Ejecuta treatFunction 4 veces
    repeat(4) {
        treatFunction() // Imprime "Have a treat!" cuatro veces
    }

    // Ejecuta trickFunction
    trickFunction() // Imprime "No treats!"
}

// trickOrTreat devuelve una lambda dependiendo de isTrick y puede usar una función adicional
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick // Devuelve función trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5)) // Imprime el resultado de extraTreat con 5 como argumento
        }
        return treat // Devuelve función treat
    }
}

// Lambda trick
val trick = {
    println("No treats!") // Imprime mensaje de truco
}

// Lambda treat
val treat: () -> Unit = {
    println("Have a treat!") // Imprime mensaje de dulce
}
