// Clase genérica que representa una pregunta con un texto, una respuesta y un nivel de dificultad
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

// Enum para representar la dificultad de la pregunta
enum class Difficulty {
    EASY, MEDIUM, HARD
}

// Interfaz que obliga a implementar una propiedad de texto de progreso y un método para imprimir una barra de progreso
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

// Clase Quiz que implementa ProgressPrintable y contiene preguntas y progreso del estudiante
class Quiz : ProgressPrintable {

    // Método que imprime la información de las tres preguntas almacenadas en esta clase
    fun printQuiz() {
        question1.let {
            println(it.questionText)   // Imprime el texto de la pregunta
            println(it.answer)         // Imprime la respuesta
            println(it.difficulty)     // Imprime la dificultad
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    // Tres preguntas definidas con diferentes tipos de respuesta y dificultades
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)

    // Objeto companion que simula el progreso de un estudiante con total de preguntas y respondidas
    companion object StudentProgress {
        var total: Int = 10      // Total de preguntas en el quiz
        var answered: Int = 3    // Preguntas respondidas hasta el momento
    }

    // Propiedad que genera el texto del progreso mostrando cuántas preguntas se han respondido de las totales
    override val progressText: String
        get() = "$answered of $total answered"

    // Método que imprime una barra visual de progreso usando caracteres especiales
    override fun printProgressBar() {
        repeat(answered) { print("▓") }          // Imprime bloques llenos según preguntas respondidas
        repeat(total - answered) { print("▒") } // Imprime bloques vacíos para las preguntas restantes
        println()
        println(progressText)                    // Imprime el texto de progreso
    }
}

// Función principal que crea un objeto Quiz, imprime las preguntas y su información
fun main() {
    Quiz().apply {
        printQuiz()
        printProgressBar()   // Opcional: También imprime la barra de progreso y texto de progreso
    }
}







