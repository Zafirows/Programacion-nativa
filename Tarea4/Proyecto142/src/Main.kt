// Interfaces con diferentes implementaciones de impresión

// Interfaz Punto con método imprimir
interface Punto {
    fun imprimir()
}

// Implementación para un punto en el plano 2D
class PuntoPlano(val x: Int, val y: Int): Punto {
    override fun imprimir() {
        println("Punto en el plano: ($x,$y)")
    }
}

// Implementación para un punto en el espacio 3D
class PuntoEspacio(val x: Int, val y: Int, val z: Int): Punto {
    override fun imprimir() {
        println("Punto en el espacio: ($x,$y,$z)")
    }
}

fun main(parametro: Array<String>) {
    val puntoPlano1 = PuntoPlano(10, 4)
    puntoPlano1.imprimir()
    val puntoEspacio1 = PuntoEspacio(20, 50, 60)
    puntoEspacio1.imprimir()
}