// Extensión de String para obtener mitades de una cadena
fun String.mitadPrimera(): String {
    return this.substring(0 until this.length / 2)
}

fun String.segundaMitad(): String {
    return this.substring(this.length / 2 until this.length)
}

fun main(args: Array<String>) {
    val cadena1 = "Viento"
    println(cadena1.mitadPrimera())
    println(cadena1.segundaMitad())
}