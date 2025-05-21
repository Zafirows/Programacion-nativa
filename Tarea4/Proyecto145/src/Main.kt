// Se define una clase de datos llamada Articulo.
// Cada artículo tiene:
// - un código (entero),
// - una descripción (texto),
// - y un precio (decimal tipo float).
data class Articulo(val codigo: Int, val descripcion: String, var precio: Float)
// Función que recibe un arreglo de artículos y los imprime uno por uno.
fun imprimir(articulos: Array<Articulo>) {
    for(articulo in articulos)
        println("Código: ${articulo.codigo} - Descripción ${articulo.descripcion} Precio: ${articulo.precio}")
}
// Esta función también recibe un arreglo de artículos.
// Recorre cada uno y aumenta su precio un 10%.
fun aumentarPrecio(articulos: Array<Articulo>) {
    for(articulo in articulos)
        articulo.precio = articulo.precio + (articulo.precio * 0.10f)
}
fun main(parametro: Array<String>) {
    // Se crea un arreglo de artículos con sus datos iniciales.
    val articulos: Array<Articulo> = arrayOf(
        Articulo(1, "papas", 7.5f),
        Articulo(2, "manzanas", 23.2f),
        Articulo(1, "naranjas", 12f),
        Articulo(1, "cebolla", 21f)
    )

    // Se imprime el listado actual de precios
    println("Listado de precios actual")
    imprimir(articulos)

    // Se aumenta el precio en 10% para cada artículo
    aumentarPrecio(articulos)

    println()
    println("Listado de precios con aumento del 10%")
    imprimir(articulos) // Se imprime el nuevo listado con precios actualizados
}
