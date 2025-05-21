// Se define una enumeración (enum class) llamada "Paises".
// Cada constante del enum representa un país y tiene asociado un valor entero: su cantidad de habitantes.
// Este valor se pasa como parámetro al constructor del enum (val habitantes: Int).
enum class Paises (val habitantes: Int) {
    BRASIL (202450649),
    COLOMBIA (50364000),
    PERU (31151643),
    VENEZUELA (31028337),
    CHILE (18261884),
    ECUADOR (16298217),
    BOLIVIA (10888000),
    PARAGUAY (6460000),
    URUGUAY (3372000)
}

// Función principal del programa, donde inicia la ejecución.
fun main(parametro: Array<String>) {

    // Se crea una variable "pais1" y se le asigna el valor BRASIL de la enumeración Paises.
    val pais1 = Paises.BRASIL

    // Se imprime el nombre del país (en este caso, "BRASIL").
    println(pais1)

    // Se imprime la cantidad de habitantes asociados a BRASIL (202450649).
    println(pais1.habitantes)
}
