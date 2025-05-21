fun main(parametro: Array<String>) {
    // Declaración de un arreglo (array) de enteros llamado "sueldos"
    val sueldos: IntArray

    // Inicialización del arreglo con 5 elementos (todos inicialmente en 0)
    sueldos = IntArray(5)

    // Carga de valores al arreglo: se piden 5 sueldos al usuario
    for(i in 0..4) {
        print("Ingrese sueldo:")
        sueldos[i] = readln().toInt() // Se convierte la entrada a entero y se guarda en la posición i
    }

    // Impresión de los sueldos ingresados
    for(i in 0..4) {
        println(sueldos[i]) // Muestra el sueldo guardado en la posición i
    }
}
