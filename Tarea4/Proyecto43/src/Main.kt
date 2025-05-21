fun main(parametro: Array<String>) {
    var cant = 0           // Contador de cuántos valores válidos (≠ 0) se ingresaron
    var suma = 0           // Acumulador para sumar los valores ingresados

    do {
        print("Ingrese un valor (0 para finalizar):")
        val valor = readln().toInt()   // Leer valor desde consola y convertirlo a entero

        // Si el valor ingresado no es 0, lo sumamos y aumentamos el contador
        if (valor != 0) {
            suma += valor       // suma = suma + valor
            cant++              // cant = cant + 1
        }
    } while (valor != 0)        // Repetimos mientras el valor sea distinto de 0

    // Verificamos si se ingresaron valores (distintos de 0)
    if (cant != 0) {
        val promedio = suma / cant    // Calculamos el promedio: suma total / cantidad de valores
        print("El promedio de los valores ingresados es: $promedio")
    } else
        print("No se ingresaron valores.")  // Si no se ingresó nada válido, mostramos este mensaje
}
