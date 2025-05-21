// Uso de interfaz Figura con clases que implementan superficie y perímetro

// Interfaz que define las operaciones comunes a las figuras geométricas
interface Figura {
    fun calcularSuperficie(): Int
    fun calcularperimetro(): Int
    fun tituloResultado() {
        println("Datos de la figura")
    }
}

// Implementación para un cuadrado
class Cuadrado(val lado: Int): Figura {
    override fun calcularSuperficie(): Int {
        return lado * lado
    }
    override fun calcularperimetro(): Int {
        return lado * 4
    }
}

// Implementación para un rectángulo
class Rectangulo(val ladoMayor: Int, val ladoMenor: Int): Figura {
    override fun calcularSuperficie(): Int {
        return ladoMayor * ladoMenor
    }
    override fun calcularperimetro(): Int {
        return (ladoMayor * 2) + (ladoMenor * 2)
    }
}

fun main(parametro: Array<String>) {
    val cuadrado1 = Cuadrado(10)
    cuadrado1.tituloResultado()
    println("Perimetro del cuadrado : ${cuadrado1.calcularperimetro()}")
    println("Superficie del cuadrado : ${cuadrado1.calcularSuperficie()}")

    val rectangulo1 = Rectangulo(10, 5)
    rectangulo1.tituloResultado()
    println("Perimetro del rectangulo : ${rectangulo1.calcularperimetro()}")
    println("Superficie del rectangulo : ${rectangulo1.calcularSuperficie()}")
}