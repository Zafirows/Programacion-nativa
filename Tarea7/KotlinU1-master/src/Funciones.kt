/*
fun main() {
    println("Happy Birthday, Rover!") // Imprime un mensaje de cumpleaños para Rover.
    println("You are now 5 years old!") // Imprime la edad actual de Rover.
}
*/



fun main() {
    // Llama a la función birthdayGreeting con la edad 5 y muestra el mensaje en consola.
    println(birthdayGreeting(age = 5))

    // Llama a la función birthdayGreeting con la edad 2 y muestra el mensaje en consola.
    println(birthdayGreeting(age = 2))
}

/*
fun birthdayGreeting() {
    println("Happy Birthday, Rover!") // Imprime el mensaje de cumpleaños.
    println("You are now 5 years old!") // Imprime la edad.
}
*/

/*
fun birthdayGreeting(name: String): String {
    val nameGreeting = "Happy Birthday, $name!" // Usa el nombre proporcionado en el mensaje.
    val ageGreeting = "You are now 5 years old!" // Edad fija.
    return "$nameGreeting\n$ageGreeting" // Retorna ambos mensajes.
}
*/



/*
fun birthdayGreeting(name: String): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}
 */

/*
fun birthdayGreeting(name: String, age: Int): String {
    val nameGreeting = "Happy Birthday, $name!" // Mensaje con nombre personalizado.
    val ageGreeting = "You are now $age years old!" // Mensaje con edad personalizada.
    return "$nameGreeting\n$ageGreeting" // Retorna ambos mensajes con salto de línea.
}
*/


fun birthdayGreeting(name: String = "Rover", age: Int): String {
    // Función que devuelve un mensaje de cumpleaños con nombre y edad.
    // El nombre tiene un valor por defecto ("Rover") si no se proporciona.
    return "Happy Birthday, $name! You are now $age years old!" // Devuelve el mensaje personalizado.
}

