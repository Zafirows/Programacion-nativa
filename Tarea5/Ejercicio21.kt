//CAPITULO 13 -Equivalentes de flujo de Java 8
// Define una lista inmutable de números del 1 al 6
val numbers = listOf(1, 2, 3, 4, 5, 6)

// Crea una nueva lista llamada 'even' que contiene
// solo los números pares de la lista 'numbers'
// La función 'filter' recibe una lambda que devuelve true
// para los elementos que queremos mantener
val even = numbers.filter { it % 2 == 0 }
