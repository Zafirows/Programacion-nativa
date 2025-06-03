/*
fun main() {
    println("New chat message from a friend") // Imprime un mensaje indicando que hay un nuevo mensaje de chat.
}
*/


/*
fun main() {
    val discountPercentage = 20 // Porcentaje de descuento aplicado a un producto.
    val item = "Google Chromecast" // Nombre del producto.
    val offer = "Sale  - Up to $discountPercentage% discount off $item! Hurry Up!" // Crea un mensaje de oferta combinando texto y variables.

    println(offer) // Imprime el mensaje de oferta en consola.
}
*/



/*
fun main() {
    val numberOfAdults = 20 // Número de adultos en la fiesta.
    val numberOfKids = 30 // Número de niños en la fiesta.
    val total = numberOfAdults + numberOfKids // Suma el total de personas.

    println("The total party size is: $total") // Imprime el tamaño total del grupo.
}
*/



/*
fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber) // Llama a la función 'add' para sumar dos números.
    val anotherResult = subtract(firstNumber, thirdNumber) // Llama a la función 'subtract' para restar dos números.

    println("$firstNumber + $secondNumber = $result") // Muestra el resultado de la suma.
    println("$firstNumber - $thirdNumber = $anotherResult") // Muestra el resultado de la resta.
}

// Función que recibe dos enteros y retorna su suma.
fun add(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}

// Función que recibe dos enteros y retorna la resta.
fun subtract(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber - secondNumber
}
*/


/*
fun main() {
    println(displayAlertMessage(emailId = "example@gmail.com")) // Llama a la función con un email y muestra el mensaje de alerta.
}

// Función que retorna un mensaje de alerta personalizado con el sistema operativo y email.
// El parámetro 'operatingSystem' tiene un valor por defecto de "Unknown OS".
fun displayAlertMessage(
    operatingSystem: String = "Unknown OS",
    emailId: String
): String {
    return "There is a new sign-in request on $operatingSystem for your Google Account $emailId."
}
*/



/*
fun main() {
    val steps = 4000 // Número de pasos caminados.
    val caloriesBurned = pedometerStepsToCalories(steps) // Calcula las calorías quemadas.
    println("Walking $steps steps burns $caloriesBurned calories") // Muestra el resultado en consola.
}

// Función que calcula las calorías quemadas en base a los pasos dados.
fun pedometerStepsToCalories(numberOfSteps: Int): Double {
    val caloriesBurnedForEachStep = 0.04 // Calorías por cada paso.
    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep // Total de calorías quemadas.
    return totalCaloriesBurned
}
*/



/*
fun main() {
    // Compara el tiempo de uso del teléfono hoy y ayer, e imprime si se usó más hoy.
    println("Have I spent more time using my phone today: ${compareTime(300, 250)}")
    println("Have I spent more time using my phone today: ${compareTime(300, 300)}")
    println("Have I spent more time using my phone today: ${compareTime(200, 220)}")
}

// Función que compara el tiempo de uso del teléfono hoy con el de ayer.
// Retorna true si hoy se usó más tiempo.
fun compareTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}
*/





/*
fun main() {
    // Imprime el pronóstico del clima para varias ciudades.
    printWeatherForCity("Ankara", 27, 31, 82)
    printWeatherForCity("Tokyo", 32, 36, 10)
    printWeatherForCity("Cape Town", 59, 64, 2)
    printWeatherForCity("Guatemala City", 50, 55, 7)
}

// Función que imprime la información del clima para una ciudad.
fun printWeatherForCity(cityName: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
    println("City: $cityName") // Imprime el nombre de la ciudad.
    println("Low temperature: $lowTemp, High temperature: $highTemp") // Imprime temperaturas mínima y máxima.
    println("Chance of rain: $chanceOfRain%") // Imprime el porcentaje de probabilidad de lluvia.
    println() // Línea en blanco para separar bloques.
}
*/
