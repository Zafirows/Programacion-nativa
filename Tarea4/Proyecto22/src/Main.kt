fun main(parametro: Array<String>) {
    // Solicita al usuario ingresar la cantidad total de preguntas del examen
    print("Ingrese la cantidad total de preguntas del examen:")
    // Lee la cantidad total de preguntas y la guarda en la variable 'totalPreguntas'
    val totalPreguntas = readln().toInt()

    // Solicita al usuario ingresar la cantidad de preguntas respondidas correctamente
    print("Ingrese la cantidad total de preguntas contestadas correctamente:")
    // Lee la cantidad de preguntas correctas y la guarda en la variable 'totalCorrectas'
    val totalCorrectas = readln().toInt()

    // Calcula el porcentaje de respuestas correctas
    val porcentaje = totalCorrectas * 100 / totalPreguntas

    // Compara el porcentaje con diferentes umbrales para determinar el nivel
    if (porcentaje >= 90)
    // Si el porcentaje es mayor o igual a 90, el nivel es máximo
        println("Nivel máximo")
    else
        if (porcentaje >= 75)
        // Si el porcentaje es mayor o igual a 75, el nivel es medio
            System.out.print("Nivel medio")
        else
            if (porcentaje >= 50)
            // Si el porcentaje es mayor o igual a 50, el nivel es regular
                println("Nivel regular")
            else
            // Si el porcentaje es menor que 50, el nivel es fuera de nivel
                println("Fuera de nivel")
}
