// Función que calcula la superficie (área) de un rectángulo.
// Se recibe la base (lado1) y la altura (lado2), y se devuelve su multiplicación.
fun retornarSuperficie(lado1: Int, lado2: Int) = lado1 * lado2

fun main(parametro: Array<String>) {
    // Sección para ingresar los datos del primer rectángulo
    println("Primer rectangulo")
    print("Ingrese lado menor del rectangulo:") // Solicita el lado menor
    val lado1 = readln().toInt()                // Lee y convierte la entrada a entero
    print("Ingrese lado mayor del rectangulo:") // Solicita el lado mayor
    val lado2 = readln().toInt()                // Lee y convierte la entrada a entero

    // Sección para ingresar los datos del segundo rectángulo
    println("Segundo rectangulo")
    print("Ingrese lado menor del rectangulo:") // Solicita el lado menor
    val lado3 = readln().toInt()                // Lee y convierte la entrada a entero
    print("Ingrese lado mayor del rectangulo:") // Solicita el lado mayor
    val lado4 = readln().toInt()                // Lee y convierte la entrada a entero

    // Compara las superficies de ambos rectángulos usando la función retornarSuperficie
    if (retornarSuperficie(lado1, lado2) == retornarSuperficie(lado3, lado4))
        print("Los dos rectangulos tienen la misma superficie")
    else if (retornarSuperficie(lado1, lado2) > retornarSuperficie(lado3, lado4))
        print("El primer rectangulo tiene una superficie mayor")
    else
        print("El segundo rectangulo tiene una superficie mayor")
}
