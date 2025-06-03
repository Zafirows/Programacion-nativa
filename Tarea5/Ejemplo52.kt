//CAPITULO 34 -Reflexión 
// Obtener la referencia a la clase 'String' usando reflection
val stringClass = String::class

// Imprime el nombre simple de la clase (sin paquete)
println(stringClass.simpleName) // Salida: String


// ------------------

// Definición de una data class llamada 'Person' con dos propiedades
data class Person(val name: String, val age: Int)

// Obtiene todas las propiedades (valores miembros) de la clase 'Person' usando reflection
val properties = Person::class.memberProperties

// Itera sobre cada propiedad y la imprime (por ejemplo: "name" y "age")
properties.forEach { println(it.name) }
