//CAPITULO 35 -Regex 
// Crea una expresión regular que coincide con uno o más dígitos (\d+)
val regex = Regex("\\d+")

// Verifica si toda la cadena "123" coincide con la expresión regular (true)
println(regex.matches("123")) // true

// Verifica si toda la cadena "abc" coincide con la expresión regular (false)
println(regex.matches("abc")) // false


// ------------------

// Expresión regular para capturar fechas en formato dd/mm/yyyy
val dateRegex = Regex("(\\d{2})/(\\d{2})/(\\d{4})")

// Busca la primera coincidencia en la cadena "15/07/2023"
val matchResult = dateRegex.find("15/07/2023")

// Si hay coincidencia, extrae los grupos capturados y los imprime
matchResult?.let {
    // Grupo 1: día (dos dígitos)
    println("Día: ${it.groupValues[1]}")  

    // Grupo 2: mes (dos dígitos)
    println("Mes: ${it.groupValues[2]}")  

    // Grupo 3: año (cuatro dígitos)
    println("Año: ${it.groupValues[3]}")  
}
