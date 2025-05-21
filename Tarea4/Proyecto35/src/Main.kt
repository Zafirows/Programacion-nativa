fun main(parametro: Array<String>) {
    var x = 1                  // Contador de alumnos
    var conta1 = 0             // Contador de aprobados (nota >= 7)
    var conta2 = 0             // Contador de reprobados (nota < 7)

    while (x <= 10) {          // Se repite 10 veces, una por cada alumno
        print("Ingrese nota:")
        val nota = readln().toInt()  // Se ingresa una nota entera

        if (nota >= 7)
            conta1 = conta1 + 1      // Suma a los aprobados
        else
            conta2 = conta2 + 1      // Suma a los reprobados

        x = x + 1                    // Pasa al siguiente alumno
    }

    println("Cantidad de alumnos con notas mayores o iguales a 7: $conta1")
    println("Cantidad de alumons con notas menores a 7: $conta2")
}
