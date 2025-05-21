// Definimos una función llamada 'calcularSueldo' que recibe:
// - un nombre (String)
// - un costo por hora (Double)
// - una cantidad de horas trabajadas (Int)
fun calcularSueldo(nombre: String, costoHora: Double, cantidadHoras: Int) {
    // Se calcula el sueldo multiplicando las horas trabajadas por el costo por hora
    val sueldo = costoHora * cantidadHoras

    // Se imprime un mensaje con los datos del trabajador y el sueldo calculado
    println("$nombre trabajó $cantidadHoras horas, se le paga por hora $costoHora por lo tanto le corresponde un sueldo de $sueldo")
}

fun main(parametro: Array<String>) {
    // Llamada a la función pasando los parámetros por posición
    calcularSueldo("juan", 10.5, 120)

    // Llamada a la función usando nombres de parámetros (puedes ponerlos en cualquier orden)
    calcularSueldo(costoHora = 12.0, cantidadHoras = 40, nombre = "ana")

    // Otra llamada usando nombre de parámetros en distinto orden
    calcularSueldo(cantidadHoras = 90, nombre = "luis", costoHora = 7.25)
}
