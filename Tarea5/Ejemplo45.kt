//CAPITULO 29 -Modismos
val nullableString: String? = "Kotlin" // Variable que puede ser null (tipo String nullable)

// Uso de 'let' con el operador seguro ?. para ejecutar un bloque solo si no es null
nullableString?.let { 
    println(it.uppercase()) // Solo se ejecuta si nullableString NO es null
}
