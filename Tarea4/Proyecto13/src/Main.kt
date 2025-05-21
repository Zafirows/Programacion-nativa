fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese la primera nota
    print("Ingrese primer nota:")
    // Lee la entrada, la convierte a entero y la guarda en 'nota1'
    val nota1 = readln().toInt()

    // Solicita al usuario que ingrese la segunda nota
    print("Ingrese segunda nota:")
    // Lee la entrada, la convierte a entero y la guarda en 'nota2'
    val nota2 = readln().toInt()

    // Solicita al usuario que ingrese la tercera nota
    print("Ingrese tercer nota:")
    // Lee la entrada, la convierte a entero y la guarda en 'nota3'
    val nota3 = readln().toInt()

    // Calcula el promedio de las tres notas
    var promedio = (nota1 + nota2 + nota3) / 3

    // Verifica si el promedio es mayor o igual a 7
    if (promedio >= 7)
    // Si el promedio es mayor o igual a 7, imprime "Promocionado"
        println("Promocionado")
}
