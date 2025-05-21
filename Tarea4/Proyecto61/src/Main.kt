fun main(parametro: Array<String>) {
    var cant1 = 0  // Cuenta cuántas piezas pesan más de 10.2 kg
    var cant2 = 0  // Cuenta cuántas piezas están dentro del rango apto (de 9.8 kg a 10.2 kg inclusive)
    var cant3 = 0  // Cuenta cuántas piezas pesan menos de 9.8 kg (pero mayores a 0)
    do {
        print("Ingrese el peso de la pieza (0 para finalizar):")
        val peso = readln().toDouble()  // Lee el peso como número decimal
        when {
            peso > 10.2 -> cant1++        // Piezas con sobrepeso
            peso >= 9.8 -> cant2++        // Piezas dentro del rango apto (9.8 a 10.2)
            peso > 0 -> cant3++           // Piezas con peso menor a 9.8 pero mayor que 0
        }
    } while(peso != 0.0)
    println("Piezas aptas: $cant2")               // Muestra cuántas piezas están en el rango correcto
    println("Piezas con un peso superior a 10.2: $cant1")  // Muestra cuántas tienen sobrepeso
    println("Piezas con un peso inferior a 9.8: $cant3")   // Muestra cuántas están por debajo del mínimo
    val suma = cant1 + cant2 + cant3
    println("Cantidad total de piezas procesadas: $suma")
}
