fun main(parametro: Array<String>) {
    print("Ingrese día: ")
    val dia = readln().toInt()  // Se solicita al usuario ingresar el día, y se convierte a tipo entero.
    print("Ingrese mes: ")
    val mes = readln().toInt()  // Se solicita al usuario ingresar el mes, y se convierte a tipo entero.
    print("Ingrese año: ")
    val año = readln().toInt()  // Se solicita al usuario ingresar el año. Este dato no se usa, pero se pide para completar la entrada.

    // Condicional que verifica si la fecha ingresada corresponde al 25 de diciembre
    if (mes == 12 && dia == 25) {
        println("La fecha ingresada corresponde a Navidad.")  // Si la fecha es 25 de diciembre, imprime este mensaje.
    } else {
        println("La fecha ingresada no corresponde a Navidad.")  // Si no es 25 de diciembre, imprime este mensaje.
    }
}

