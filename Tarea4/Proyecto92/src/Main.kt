// Función que imprime un título y debajo lo “subraya” con un carácter dado.
// Parámetros:
//  - titulo: el texto que se mostrará como título.
//  - caracter: el símbolo con el que se subrayará el título (por defecto "*").
fun tituloSubrayado(titulo: String, caracter: String = "*") {
    // Imprime el título tal cual
    println(titulo)

    // Repite la impresión del 'caracter' tantas veces como la longitud del título
    // para crear una línea de subrayado de igual longitud.
    for (i in 1..titulo.length)
        print(caracter)

    // Mueve el cursor a la siguiente línea tras el subrayado
    println()
}

fun main(parametro: Array<String>) {
    // Llama a la función usando el carácter predeterminado (“*”)
    tituloSubrayado("Sistema de Administracion")

    // Llama a la función especificando un guion (“-”) como carácter de subrayado
    tituloSubrayado("Ventas", "-")
}