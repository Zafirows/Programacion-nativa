//CAPITULO 2 -Advertencias con Kotlin
// 'text' es una variable inmutable (val) que obtiene el texto del textField de forma segura
val text = view.textField?.text?.toString() ?: ""
