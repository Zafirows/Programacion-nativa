//CAPITULO 24 -Kotlin para desarrolladores de Java
// 'description' recibe un valor según la evaluación de condiciones en el 'when'
val description = when {
    x == 0 -> "cero"       // Si x es igual a 0, description será "cero"
    x > 0 -> "positivo"    // Si x es mayor que 0, description será "positivo"
    else -> "negativo"     // Si ninguna condición anterior se cumple, description será "negativo"
}
