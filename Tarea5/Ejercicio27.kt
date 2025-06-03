//CAPITULO 16 -Funciones
// Define una función lambda llamada 'isPositive' que recibe un entero 'x'
// y devuelve true si 'x' es mayor que 0, false en caso contrario
val isPositive = { x: Int -> x > 0 }

// Aplica la función 'filter' a la lista de números [-2, -1, 0, 1, 2]
// 'filter' selecciona solo los elementos para los cuales la función lambda retorna true
val filtered = listOf(-2, -1, 0, 1, 2).filter(isPositive)

// Resultado: filtered = [1, 2]
