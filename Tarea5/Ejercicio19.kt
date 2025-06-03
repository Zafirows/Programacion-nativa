//CAPITULO 10 -Delegación de clase
// Define una interfaz llamada Foo con una función abstracta example()
interface Foo {
    fun example()
}

// Define una clase Bar que tiene su propia función example()
// Esta función imprime "Hello, world!"
class Bar {
    fun example() {
        println("Hello, world!")
    }
}

// Define una clase Baz que implementa la interfaz Foo
// En lugar de implementar la función example() directamente,
// delega su implementación a un objeto de tipo Bar que recibe en el constructor
class Baz(b: Bar) : Foo by b
