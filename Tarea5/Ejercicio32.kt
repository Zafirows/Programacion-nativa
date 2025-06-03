//CAPITULO 20 -Herencia de clase
// Declaramos una clase abierta llamada Base.
// 'open' permite que esta clase pueda ser heredada por otras (por defecto, las clases en Kotlin son 'final').
open class Base(val prop: String)
// Declaramos una clase llamada Derived que hereda de Base.
// En el constructor de Derived recibimos un parámetro 'prop', que se pasa al constructor de la clase Base.
class Derived(prop: String) : Base(prop)
