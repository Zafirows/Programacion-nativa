// ========================================
// Definición de una anotación personalizada
// ========================================

@Target(
    AnnotationTarget.CLASS,             // Se puede usar en clases
    AnnotationTarget.FUNCTION,          // Se puede usar en funciones
    AnnotationTarget.VALUE_PARAMETER,   // Se puede usar en parámetros
    AnnotationTarget.EXPRESSION         // Se puede usar en expresiones
)
@Retention(AnnotationRetention.SOURCE)  // Solo vive en el código fuente (no en el bytecode)
@MustBeDocumented                       // Será visible en la documentación generada
annotation class Fancy                  // Se define la anotación llamada @Fancy

// ========================================
// Uso de la anotación en diferentes partes
// ========================================

@Fancy // Aplicado a una clase
class MyClass {

    @Fancy // Aplicado a una función
    fun decoratedFunction(@Fancy name: String) { // Aplicado a un parámetro
        val result = @Fancy "Decorated String"   // Aplicado a una expresión
        println(result)
    }
}