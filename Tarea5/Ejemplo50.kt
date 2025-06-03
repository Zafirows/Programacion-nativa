//CAPITULO 32 -Propiedades delegadas
import kotlin.properties.Delegates

// Lazy initialization
// Declaración de una propiedad llamada 'lazyValue' que se inicializa de forma "perezosa" (lazy)
val lazyValue: String by lazy {
    println("Calculando valor")  // Este código solo se ejecutará la primera vez que se acceda a 'lazyValue'
    "Resultado"                  // El valor que se asignará a 'lazyValue' después de la primera evaluación
}


// Observable property
// Declara una variable observable llamada 'observed' con valor inicial 0
var observed by Delegates.observable(0) { _, old, new ->
    // Este bloque se ejecuta cada vez que 'observed' cambia de valor
    // '_' ignora el parámetro que representa la propiedad (no se usa aquí)
    // 'old' es el valor anterior de la variable
    // 'new' es el nuevo valor asignado

    println("Cambiado de $old a $new") // Imprime el cambio de valor
}

