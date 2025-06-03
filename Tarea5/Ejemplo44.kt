//CAPITULO 29 -Modismos
// La palabra clave `data` indica que esta clase está pensada para “transportar datos”.
// Kotlin generará automáticamente varios métodos útiles (equals, hashCode, toString, copy, etc.).
data class User(
    val name: String, // Propiedad inmutable (val) que guarda el nombre
    val age: Int      // Propiedad inmutable que guarda la edad
)
