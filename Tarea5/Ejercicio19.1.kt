//CAPITULO 11 -Edificio DSL (Profundización)
// Define una clase llamada Person con dos propiedades: name y age
class Person {
    var name: String = ""
    var age: Int = 0
}

// Define una función de ayuda llamada 'person' que recibe un bloque de código
// Ese bloque tiene como receptor a un objeto de tipo Person
// 'Person.() -> Unit' significa que dentro del bloque puedes acceder a las propiedades de Person directamente
fun person(block: Person.() -> Unit): Person {
    // Crea una nueva instancia de Person y aplica el bloque sobre ella
    return Person().apply(block)
}

// Llama a la función 'person' y pasa un bloque de configuración
// Dentro del bloque, puedes acceder a 'name' y 'age' como si estuvieras dentro de la clase
val p = person {
    name = "Ana"  // Establece el nombre en "Ana"
    age = 30      // Establece la edad en 30
}
