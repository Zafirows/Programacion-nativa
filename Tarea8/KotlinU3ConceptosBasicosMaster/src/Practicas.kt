/*
fun main() {
    val morningNotification = 51  // Número de notificaciones por la mañana
    val eveningNotification = 135 // Número de notificaciones por la tarde

    // Se imprime el resumen de notificaciones para cada caso
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

// Función que imprime un resumen según la cantidad de notificaciones
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        // Si son menos de 100, se muestra el número exacto
        println("You have ${numberOfMessages} notifications.")
    } else {
        // Si son 100 o más, se muestra "99+"
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}
*/


/*
fun main() {
    val child = 5   // Edad de un niño
    val adult = 28  // Edad de un adulto
    val senior = 87 // Edad de un adulto mayor

    val isMonday = true // Día de la semana (lunes)

    // Se imprime el precio de la entrada según la edad y si es lunes
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

// Función que calcula el precio del ticket según la edad y si es lunes
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age) {
        in 0..12 -> 15 // Precio para niños
        in 13..60 -> if (isMonday) 25 else 30 // Precio reducido si es lunes
        in 61..100 -> 20 // Precio para mayores
        else -> -1 // Edad no válida
    }
}
*/


/*
fun main() {
    // Se convierte 27.0 °C a °F usando una fórmula lambda
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
    // Se convierte 350.0 K a °C
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    // Se convierte 10.0 °F a K
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}

// Función que imprime el resultado de la conversión de temperatura
fun printFinalTemperature(
    initialMeasurement: Double, // Valor inicial
    initialUnit: String, // Unidad inicial
    finalUnit: String, // Unidad final
    conversionFormula: (Double) -> Double // Función lambda de conversión
) {
    // Se aplica la conversión y se formatea con dos decimales
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
*/


/*
fun main() {
    // Se crea un objeto Song
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
    // Se imprime la descripción
    brunoSong.printDescription()
    // Se verifica si es popular
    println(brunoSong.isPopular)
}

// Clase Song con atributos y propiedades
class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
){
    // Propiedad que indica si una canción es popular
    val isPopular: Boolean
        get() = playCount >= 1000

    // Método que imprime la descripción de la canción
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
*/


/*
fun main() {
    // Se crean dos personas, una refiriendo a la otra
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    // Se muestran los perfiles
    amanda.showProfile()
    atiqah.showProfile()
}

// Clase Person con nombre, edad, hobby y referidor opcional
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if(hobby != null) {
            print("Likes to $hobby. ")
        }
        if(referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if(referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            } else {
                print(".")
            }
        } else {
            print("Doesn't have a referrer.")
        }
        print("\n\n")
    }
}
*/


/*
open class Phone(var isScreenLightOn: Boolean = false){
    // Método para encender la pantalla
    open fun switchOn() {
        isScreenLightOn = true
    }

    // Método para apagar la pantalla
    fun switchOff() {
        isScreenLightOn = false
    }

    // Verifica si la luz de la pantalla está encendida o apagada
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

// Subclase de Phone que puede plegarse
class FoldablePhone(var isFolded: Boolean = true): Phone() {
    // Solo enciende la pantalla si el teléfono está desplegado
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }

    // Método para plegar el teléfono
    fun fold() {
        isFolded = true
    }

    // Método para desplegar el teléfono
    fun unfold() {
        isFolded = false
    }
}

fun main() {
    val newFoldablePhone = FoldablePhone()

    // Intenta encenderlo estando plegado (no se enciende)
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()

    // Lo despliega y vuelve a encender
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}
*/


// Código activo (no comentado)
fun main() {
    // Se crea una oferta ganadora (bid) con cantidad y postor
    val winningBid = Bid(5000, "Private Collector")

    // Se imprime el precio final de dos objetos
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.") // Usa bid
    println("Item B is sold at ${auctionPrice(null, 3000)}.") // Usa precio mínimo
}

// Clase Bid que representa una oferta
class Bid(val amount: Int, val bidder: String)

// Función que devuelve el precio de una subasta
// Si existe una oferta válida, se usa su valor; si no, el precio mínimo
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}
