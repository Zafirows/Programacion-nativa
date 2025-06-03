//CAPITULO 29 -Modismos
// Crea un nuevo TextView (una vista de texto) usando el contexto actual (por ejemplo, una Activity)
val myTextView = TextView(context).apply { 
    // Asigna el texto que se mostrará en el TextView
    text = "Hola"
    
    // Asigna el tamaño del texto en puntos flotantes (16f equivale a 16sp)
    textSize = 16f
} // 'apply' devuelve el mismo objeto ya configurado, que se guarda en 'myTextView'
