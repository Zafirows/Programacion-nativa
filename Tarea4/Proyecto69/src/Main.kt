fun main(parametro: Array<String>) {
    // Variables contadoras para clasificar las familias según la cantidad de hijos
    var conta1 = 0 // Contador para familias con 0 hijos
    var conta2 = 0 // Contador para familias con 1 hijo
    var conta3 = 0 // Contador para familias con 2 hijos
    var conta4 = 0 // Contador para familias con más de 2 hijos

    // Repite el ingreso de datos 10 veces (una por familia)
    for(i in 1..10) {
        // Solicita al usuario que ingrese la cantidad de hijos para una familia
        print("Ingrese la cantidad de hijos de la familia:")
        val cantidad = readln().toInt()

        // Clasifica la cantidad de hijos usando 'when' y actualiza el contador correspondiente
        when (cantidad) {
            0 -> conta1++             // Si la familia tiene 0 hijos
            1 -> conta2++             // Si la familia tiene 1 hijo
            2 -> conta3++             // Si la familia tiene 2 hijos
            else -> conta4++          // Si tiene más de 2 hijos
        }
    }

    // Muestra los resultados acumulados
    println("Cantidad de familias con 0 hijos: $conta1")
    println("Cantidad de familias con 1 hijos: $conta2")
    println("Cantidad de familias con 2 hijos: $conta3")
    println("Cantidad de familias con más de 2 hijos: $conta4")
}
