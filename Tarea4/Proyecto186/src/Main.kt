// Definición de una clase de datos para representar una fecha
data class Fecha(val dia: Int, val mes: Int, val año: Int)

// Función que permite ingresar varias fechas con actividades
fun cargar(agenda: MutableMap<Fecha, String>) {
    do {
        println("Ingrese fecha")
        print("Ingrese el día:")
        val dia = readln().toInt()
        print("Ingrese el mes:")
        val mes = readln().toInt()
        print("Ingrese el año:")
        val año = readln().toInt()

        print("Ingrese todas las actividades para ese día:")
        val actividades = readln()

        // Se guarda en el mapa la actividad asociada a la fecha
        agenda[Fecha(dia, mes, año)] = actividades

        // Pregunta si desea ingresar otra fecha
        print("Ingrese otra fecha (si/no):")
        val opcion = readln()
    } while (opcion.lowercase() == "si")
}

// Función para mostrar toda la agenda
fun imprimir(agenda: MutableMap<Fecha, String>) {
    for ((fecha, actividad) in agenda) {
        println("Fecha ${fecha.dia}/${fecha.mes}/${fecha.año}")
        println("Actividades: $actividad")
        println()
    }
}

// Función que permite consultar actividades por una fecha específica
fun consultaFecha(agenda: MutableMap<Fecha, String>) {
    println("Ingrese una fecha a consultar")
    print("Ingrese el día:")
    val dia = readln().toInt()
    print("Ingrese el mes:")
    val mes = readln().toInt()
    print("Ingrese el año:")
    val año = readln().toInt()

    val fecha = Fecha(dia, mes, año)

    // Consulta si la fecha existe en la agenda
    if (fecha in agenda)
        println("Actividades: ${agenda[fecha]}")
    else
        println("No existen actividades registradas para dicha fecha")
}

// Función principal
fun main(args: Array<String>) {
    val agenda: MutableMap<Fecha, String> = mutableMapOf()

    cargar(agenda)       // Cargar datos
    imprimir(agenda)     // Mostrar todos los datos
    consultaFecha(agenda) // Consultar una fecha puntual
}
