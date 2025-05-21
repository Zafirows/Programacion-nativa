// Uso del operador in para verificar si un documento está en un curso
data class Alumno(val documento: Int, val nombre: String)

class Curso {
    val alumnos = arrayOf(
        Alumno(123456, "Marcos"),
        Alumno(666666, "Ana"),
        Alumno(777777, "Luis")
    )

    // Sobrecarga del operador 'in'
    operator fun contains(documento: Int): Boolean {
        return alumnos.any { documento == it.documento }
    }
}

fun main(args: Array<String>) {
    val curso1 = Curso()
    if (123456 in curso1)
        println("El alumno Marcos está inscripto en el curso")
    else
        println("El alumno Marcos no está inscripto en el curso")
}