fun main(parametro: Array<String>) {
    // Inicialización de las variables que llevarán el conteo de aprobados y reprobados
    var aprobados = 0
    var reprobados = 0

    // Bucle for que se repite 10 veces (para ingresar las notas de 10 alumnos)
    for(i in 1..10) {
        // Solicitar al usuario que ingrese la nota de un estudiante
        print("Ingrese nota:")
        val nota = readln().toInt()  // Lee la entrada como un número entero

        // Si la nota es mayor o igual a 7, se considera aprobado
        if (nota >= 7)
            aprobados++  // Incrementa el contador de aprobados
        else
            reprobados++  // Si la nota es menor a 7, se considera reprobado
    }

    // Al finalizar el ciclo, se imprime la cantidad de alumnos aprobados
    println("Cantidad de alumnos con notas mayores o iguales a 7: $aprobados")

    // Se imprime la cantidad de alumnos reprobados (con notas menores a 7)
    println("Cantidad de alumnos con notas menores a 7: $reprobados")
}
