fun main(parametro: Array<String>) {
    print("Cuantos empleados tiene la empresa:")
    val n = readln().toInt()     // Cantidad de empleados a registrar

    var x = 1                    // Contador para el bucle
    var conta1 = 0               // Contador para sueldos entre 100 y 300
    var conta2 = 0               // Contador para sueldos mayores a 300
    var gastos = 0.0             // Acumulador de sueldos totales

    while (x <= n) {             // Bucle que se repite n veces
        print("Ingrese el sueldo del empleado:")
        val sueldo = readln().toDouble()  // Leer sueldo como número decimal

        if (sueldo <= 300)
            conta1 += 1                  // Contar sueldo bajo o medio
        else
            conta2 += 1                  // Contar sueldo alto

        gastos += sueldo                 // Acumular sueldo en el total
        x += 1
    }

    // Mostrar resultados
    println("Cantidad de empleados con sueldos entre 100 y 300: $conta1")
    println("Cantidad de empleados con sueldos mayor a 300: $conta2")
    System.out.print("Gastos total de la empresa en sueldos: $gastos")
}
