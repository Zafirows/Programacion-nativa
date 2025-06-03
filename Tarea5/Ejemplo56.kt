//CAPITULO 38 -Tipo de constructores seguros
// Clase principal que representa un documento HTML
class HTML {
    // Función para crear un 'body' y aplicar una función de inicialización (DSL)
    fun body(init: Body.() -> Unit) = Body().apply(init)
}

// Clase que representa el body del HTML
class Body {
    // Función para crear un párrafo <p> y aplicar una función de inicialización
    fun p(init: P.() -> Unit) = P().apply(init).toString()
}

// Clase que representa un párrafo <p>
class P {
    var text = ""  // Contenido del párrafo

    // Convierte el objeto P a su representación HTML en String
    override fun toString() = "<p>$text</p>"
}

// Función para construir un objeto HTML usando un DSL (Domain Specific Language)
fun html(init: HTML.() -> Unit): HTML = HTML().apply(init)


// ---------------------
// Uso del builder:
// Construye un HTML con un body que contiene un párrafo con texto "Hola mundo"
val htmlContent = html {
    body {
        p {
            text = "Hola mundo"
        }
    }
}
