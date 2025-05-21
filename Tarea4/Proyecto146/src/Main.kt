// Se define una clase llamada Dado con una propiedad mutable llamada 'valor'.
// Por defecto, el valor del dado es 1 (valor inicial si no se pasa ningún argumento).
class Dado (var valor: Int = 1){

    // Método para simular tirar el dado.
    // Usa Math.random() que genera un número aleatorio entre 0 y 1,
    // lo multiplica por 6 y le suma 1 para obtener un valor entre 1 y 6.
    // Luego convierte ese valor a entero (toInt()).
    fun tirar() {
        valor = ((Math.random() * 6) + 1).toInt()
    }

    // Método para imprimir el valor actual del dado en consola.
    fun imprimir() {
        println("Valor del dado: $valor")
    }
}
fun main(parametro: Array<String>) {
    // Se crea un arreglo de 5 objetos de tipo Dado.
    // Todos los dados se crean con el valor por defecto (1).
    var dados: Array<Dado> = arrayOf(Dado(), Dado(), Dado(), Dado(), Dado())

    // Se recorre el arreglo y se tira cada dado (se le asigna un nuevo valor aleatorio entre 1 y 6).
    for(dado in dados)
        dado.tirar()

    // Se recorre nuevamente el arreglo y se imprime el valor de cada dado.
    for(dado in dados)
        dado.imprimir()
}
