//CAPITULO 36 -Seguridad nula
// Safe call operator: accede a 'length' solo si 'nullableString' NO es null, sino devuelve null
val length: Int? = nullableString?.length

// Elvis operator: si 'nullableString?.length' es null, entonces usa 0 como valor por defecto
val safeLength = nullableString?.length ?: 0

// Not-null assertion: fuerza a que 'nullableString' NO sea null; lanza excepción si es null
val forcedLength = nullableString!!.length
