//CAPITULO 30 -Objetos singleton
// Declaración de un objeto singleton llamado 'DatabaseManager'
object DatabaseManager {

    // Bloque de inicialización: se ejecuta automáticamente la primera vez que se accede al objeto
    init {
        println("Inicializando conexión a BD") // Simula la conexión a la base de datos
    }

    // Función miembro del objeto que simula la ejecución de una consulta SQL
    fun query(sql: String) {
        // Aquí iría el código para ejecutar la consulta en la base de datos
        println("Ejecutando: $sql") // Para mostrar qué consulta se está ejecutando
    }
}

// ---------------- USO ---------------------

// Llamada al método 'query' del objeto singleton
DatabaseManager.query("SELECT * FROM users")

// Al ejecutar esta línea por primera vez, se imprimirá:
// Inicializando conexión a BD
// Ejecutando: SELECT * FROM users
