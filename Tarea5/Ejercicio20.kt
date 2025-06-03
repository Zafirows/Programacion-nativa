//CAPITULO 12 -Enumerar
// Definición de un enum llamado Color
// Cada valor del enum tiene asociado un parámetro 'rgb' de tipo Int
enum class Color(val rgb: Int) {
    RED(0xFF0000),   // Color rojo con valor hexadecimal RGB
    GREEN(0x00FF00), // Color verde con valor hexadecimal RGB
    BLUE(0x0000FF)   // Color azul con valor hexadecimal RGB
}
