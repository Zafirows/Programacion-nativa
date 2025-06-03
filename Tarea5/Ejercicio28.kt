//CAPITULO 17 -Fundamentos de Kotlin (Completo)
// Definimos una función llamada getLength que recibe un parámetro llamado 'text'.
// Este parámetro puede ser un String o null (por eso se usa String?).
fun getLength(text: String?): Int {
    
    // Usamos el operador de seguridad null (?.) para acceder a la propiedad 'length' del String.
    // Si 'text' no es null, devuelve su longitud.
    // Si 'text' es null, se usa el operador Elvis (?:) para devolver 0 como valor por defecto.
    return text?.length ?: 0
}
