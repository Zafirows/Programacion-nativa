fun main(parametro: Array<String>) {
    // Declaramos una variable llamada 'total' que almacenará la suma de los sueldos altos
    var total = 0

    // Creamos un bucle que se repite 10 veces, del 1 al 10 inclusive
    for(i in 1..10) {
        // Solicitamos al usuario que ingrese el sueldo del operario
        print("ingrese sueldo del operario:")
        // Leemos la entrada del usuario como texto y la convertimos a entero
        val sueldo = readln().toInt()

        // Usamos una expresión 'when' para clasificar el sueldo ingresado
        total += when {
            sueldo > 5000 -> {
                // Si el sueldo es mayor a 5000, es considerado "Sueldo alto"
                println("Sueldo alto")
                // Se suma este sueldo al total porque es un sueldo alto
                sueldo
            }
            sueldo > 2000 -> {
                // Si el sueldo es mayor a 2000 pero menor o igual a 5000, es "Sueldo medio"
                println("Sueldo medio")
                // No se suma al total porque no es sueldo alto
                0
            }
            else -> {
                // Si el sueldo es menor o igual a 2000, se considera "Sueldo bajo"
                println("Sueldo bajo")
                // No se suma al total porque no es sueldo alto
                0
            }
        }
    }

    // Finalmente, mostramos el gasto total en sueldos altos
    println("Gastos totales en sueldos altos: $total")
}
