// Definimos la clase Empleado con dos propiedades: nombre (String) y sueldo (Double)
class Empleado(var nombre: String, var sueldo: Double) {

    // Función que imprime la información del empleado
    fun imprimir() {
        println("$nombre tiene un sueldo de $sueldo")
    }
}

// Función que recibe una lista mutable de empleados y calcula la suma total de sus sueldos
fun calcularGastos(empleados: MutableList<Empleado>) {
    // sumByDouble suma los sueldos de todos los empleados en la lista
    val suma = empleados.sumByDouble { it.sueldo }
    println("Total de gastos de la empresa: $suma")
}

fun main(args: Array<String>) {
    // Creamos una lista mutable de empleados, con tres empleados iniciales
    val empleados: MutableList<Empleado> = mutableListOf(
        Empleado("Juan", 2000.0),
        Empleado("Ana", 3500.0),
        Empleado("Carlos", 1500.0)
    )

    // Imprimimos los datos de cada empleado
    empleados.forEach { it.imprimir() }

    // Calculamos e imprimimos el gasto total en sueldos
    calcularGastos(empleados)

    // Agregamos un nuevo empleado a la lista
    empleados.add(Empleado("Marcos", 3000.0))

    // Indicamos que se recalcularán los gastos con el nuevo empleado
    println("Gastos luego de ingresar un nuevo empleado que cobra 3000")

    // Volvemos a calcular los gastos con el nuevo empleado incluido
    calcularGastos(empleados)
}
