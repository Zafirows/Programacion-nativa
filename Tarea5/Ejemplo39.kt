//CAPITULO 24 -Lambdas básicas
// Definimos una lambda (función anónima) que recibe dos enteros y devuelve su suma
val sum = { a: Int, b: Int -> a + b }
// Creamos una lista de enteros y usamos la función 'filter' con una lambda para obtener solo los números positivos
val positives = listOf(-2, -1, 0, 1, 2).filter { it > 0 }
