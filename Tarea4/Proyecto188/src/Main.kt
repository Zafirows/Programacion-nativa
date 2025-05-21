// Verificación de fechas usando Set de objetos data class
data class Fecha(val dia: Int, val mes: Int, val año: Int)

fun main(args: Array<String>) {
    val feriados: Set<Fecha> = setOf(
        Fecha(1, 1, 2017),
        Fecha(25, 12, 2017)
    )

    println("Ingrese una fecha")
    print("Día: ")
    val dia = readLine()!!.toInt()
    print("Mes: ")
    val mes = readLine()!!.toInt()
    print("Año: ")
    val año = readLine()!!.toInt()

    if (Fecha(dia, mes, año) in feriados)
        println("La fecha ingresada es feriado")
    else
        println("La fecha ingresada no es feriado")
}