fun main(parametro: Array<String>) {
    // Inicialización de la variable suma, que acumulará la suma de los valores
    var suma = 0

    // Bucle for que se repite 10 veces, desde 1 hasta 10 (inclusive)
    for(i in 1..10) {
        // Solicitar al usuario que ingrese un valor
        print("Ingrese un valor:")

        // Leer el valor ingresado como un número entero
        val valor = readln().toInt()

        // Sumar el valor ingresado a la variable suma
        suma += valor
    }

    // Imprimir el total acumulado (la suma de los 10 valores)
    println("La suma de los valores ingresados es $suma")

    // Calcular el promedio dividiendo la suma entre 10
    val promedio = suma / 10

    // Imprimir el promedio de los valores
    println("Su promedio es $promedio")
}
