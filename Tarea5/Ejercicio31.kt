//CAPITULO 19 -Genéricos
// Definimos una clase genérica llamada Box, que acepta un tipo genérico T
class Box<T>(t: T) {
    // Creamos una propiedad mutable llamada 'value', que almacena el valor recibido
    var value = t
}
// Creamos una instancia de Box con el tipo específico Int y le pasamos el valor 1
val box = Box<Int>(1)
