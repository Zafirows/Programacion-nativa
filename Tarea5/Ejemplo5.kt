fun main(args: Array<String>) {
    // Imprime en pantalla un mensaje para pedir dos números al usuario
    println("Enter Two number")
    
    // Lee una línea del input del usuario (readLine()), que puede ser nula
    // El operador '!!' fuerza a Kotlin a tratar el resultado como no nulo
    // Si es nulo, lanza una excepción NullPointerException (NPE)
    // Luego divide la línea en dos partes usando el espacio ' ' como separador
    // Finalmente, usa destructuración para asignar las dos partes a las variables 'a' y 'b'
    var (a, b) = readLine()!!.split(' ')
    
    // Llama a la función maxNum con los dos números convertidos a Int y muestra el resultado
    println("Max number is : ${maxNum(a.toInt(), b.toInt())}")
}

// Función que recibe dos enteros y devuelve el mayor de ellos
fun maxNum(a: Int, b: Int): Int {
    // Variable para almacenar el valor máximo
    // Usa una expresión if para decidir cuál número es mayor
    var max = if (a > b) {
        // Si 'a' es mayor, imprime su valor y retorna 'a'
        println("The value of a is $a")
        a
    } else {
        // Si 'b' es mayor o igual, imprime su valor y retorna 'b'
        println("The value of b is $b")
        b
    }
    // Retorna el número máximo encontrado
    return max
}
