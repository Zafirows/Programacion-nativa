fun main(parametro: Array<String>) {
    print("Ingrese un valor:")  // Pide al usuario que ingrese un valor
    val valor = readln().toInt()  // Lee el valor ingresado y lo convierte a un número entero (Int)
    var x = 1  // Inicializa la variable 'x' en 1

    while (x <= valor) {  // El ciclo while continuará mientras 'x' sea menor o igual a 'valor'
        println(x)  // Imprime el valor actual de 'x'
        x = x + 1  // Incrementa 'x' en 1
    }
}
