/*
// Definición de la clase de datos Event
data class Event(
    val title: String,
    val description: String?,
    val daypart: String,
    val durationInMinutes: Int
)

fun main() {
    // Creación de una instancia de Event con los datos indicados
    val studyEvent = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = "Evening",
        durationInMinutes = 15
    )

    // Impresión del objeto
    println(studyEvent)
}
 */


/*
// Enum que define las franjas horarias válidas
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

// Clase de datos Event usando el enum Daypart
data class Event(
    val title: String,
    val description: String?,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    // Crear una instancia del evento usando el enum
    val studyEvent = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        durationInMinutes = 15
    )

    // Imprimir el objeto
    println(studyEvent)
}
 */


/*
// Enum para la franja horaria
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

// Clase de datos Event
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    // Crear eventos individuales
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    // Agrupar todos los eventos en una lista mutable
    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)

    // Mostrar el total de eventos
    println("Total events scheduled: ${events.size}")

    // Imprimir cada evento
    events.forEach { println(it) }
}
 */


/*
// Enum para la franja horaria
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

// Clase de datos Event
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    // Crear eventos
    val event1 = Event("Wake up", "Time to get up", Daypart.MORNING, 0)
    val event2 = Event("Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event("Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event("Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event("Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event("Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    // Lista de eventos
    val events = mutableListOf(event1, event2, event3, event4, event5, event6)

    // Filtrar eventos cortos (menos de 60 minutos)
    val shortEvents = events.filter { it.durationInMinutes < 60 }

    // Imprimir resumen
    println("You have ${shortEvents.size} short events.")
}
 */


/*
// Enum para la franja horaria
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

// Clase de datos Event
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    // Crear eventos
    val event1 = Event("Wake up", "Time to get up", Daypart.MORNING, 0)
    val event2 = Event("Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event("Morning workout", daypart = Daypart.MORNING, durationInMinutes = 30)
    val event4 = Event("Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event5 = Event("Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event6 = Event("Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event7 = Event("Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    val event8 = Event("Read a book", daypart = Daypart.EVENING, durationInMinutes = 20)

    // Lista de eventos
    val events = mutableListOf(event1, event2, event3, event4, event5, event6, event7, event8)

    // Agrupar eventos por franja horaria
    val groupedEvents = events.groupBy { it.daypart }

    // Imprimir resumen
    groupedEvents.forEach { (daypart, eventsInPart) ->
        println("${daypart.name.capitalize()}: ${eventsInPart.size} events")
    }
}
 */


/*
data class Event(val title: String, val time: String)

fun main() {
    val events = listOf(
        Event("Breakfast Meeting", "08:00 AM"),
        Event("Team Standup", "10:00 AM"),
        Event("Lunch with Client", "12:30 PM"),
        Event("Project Presentation", "03:00 PM"),
        Event("Wrap-up and Review", "05:00 PM")
    )

    println("Last event of the day: ${events.last().title}")
}
 */



data class Event(val title: String, val time: String, val durationInMinutes: Int)

// Propiedad de extensión para Event
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    val events = listOf(
        Event("Breakfast Meeting", "08:00 AM", 45),
        Event("Team Standup", "10:00 AM", 30),
        Event("Lunch with Client", "12:30 PM", 90),
        Event("Project Presentation", "03:00 PM", 120),
        Event("Wrap-up and Review", "05:00 PM", 50)
    )

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}
