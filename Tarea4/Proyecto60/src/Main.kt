fun main(parametros: Array<String>) {
    // Entrada de tres notas
    print("Ingrese primer nota:")
    val nota1 = readln().toInt()
    print("Ingrese segunda nota:")
    val nota2 = readln().toInt()
    print("Ingrese tercer nota:")
    val nota3 = readln().toInt()

    // Cálculo del promedio
    val promedio = (nota1 + nota2 + nota3) / 3

    // Clasificación según promedio
    when {
        promedio >= 7 -> print("Promocionado")
        promedio >= 4 -> print("Regular")
        else -> print("Libre")
    }
}
