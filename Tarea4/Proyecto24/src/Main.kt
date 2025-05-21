fun main(parametro: Array<String>) {
    // Solicitar al usuario ingresar el día, mes y año
    print("Ingrese día: ")
    val dia = readln().toInt()
    print("Ingrese mes: ")
    val mes = readln().toInt()
    print("Ingrese año: ")
    val año = readln().toInt()

    // Verificar si la fecha es válida
    if (mes in 1..12 && dia in 1..31) {
        // Verificar el trimestre correspondiente
        when (mes) {
            1, 2, 3 -> println("Corresponde al primer trimestre.")
            4, 5, 6 -> println("Corresponde al segundo trimestre.")
            7, 8, 9 -> println("Corresponde al tercer trimestre.")
            10, 11, 12 -> println("Corresponde al cuarto trimestre.")
            else -> println("Mes no válido.")
        }
    } else {
        println("Fecha no válida.")
    }
}
