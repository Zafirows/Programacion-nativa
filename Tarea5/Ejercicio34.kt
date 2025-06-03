//CAPITULO 22 -Interfaces
// Definimos una interfaz llamada MyInterface
interface MyInterface {

    // Declaramos un método abstracto 'bar' que las clases que implementen esta interfaz deben definir
    fun bar()

    // Declaramos un método 'foo' con una implementación por defecto
    fun foo() {
        println("Default implementation")
    }
}

// ===== EJEMPLOS COMBINADOS KOTLIN (Capítulos 23-38) =====
// Notas importantes:
// 1. Algunos ejemplos requieren dependencias específicas (Android, JUnit, etc.)
// 2. Los ejemplos de DSL y builders son simplificados para mostrar el concepto básico
// 3. Las corrutinas requieren el contexto adecuado para ejecutarse