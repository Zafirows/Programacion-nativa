//CAPITULO 23 -JUnit
// Esta clase de prueba usa JUnit, por lo que necesitas agregar la dependencia de JUnit en tu proyecto.

class MyTest {

    // Declaramos una regla de JUnit llamada tempFolder que crea una carpeta temporal para las pruebas.
    // La anotación '@get:Rule' indica que esto es una regla que JUnit ejecutará antes y después de cada test.
    @get:Rule
    val tempFolder = TemporaryFolder()

    // Definimos una función de prueba anotada con @Test
    @Test
    fun test() {
        // Creamos un nuevo archivo temporal dentro de la carpeta temporal llamada "test.txt"
        val file = tempFolder.newFile("test.txt")

        // Aquí irían las pruebas que involucren el archivo temporal, por ejemplo, escribir o leer datos
    }
}
