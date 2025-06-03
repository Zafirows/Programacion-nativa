//CAPITULO 28 -Modificadores de visibilidad
class VisibilityExample {
    public val publicProp = "Público"       // Visible desde cualquier parte. Este es el valor por defecto si no se especifica visibilidad.

    private val privateProp = "Privado"     // Solo accesible dentro de esta clase. Ni siquiera las subclases pueden verlo.

    internal val internalProp = "Interno"   // Visible dentro del mismo **módulo** (por ejemplo, un mismo proyecto o paquete compilado).

    protected val protectedProp = "Protegido" // Solo accesible dentro de esta clase y sus **subclases** (incluso si están en otros archivos o paquetes).
}
