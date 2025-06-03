//CAPITULO 31 -Parámetros Vararg
val items = arrayOf("uno", "dos", "tres") 
// Crea un arreglo (array) de Strings con tres elementos

printAll(*items) 
// Llama a la función printAll usando el operador '*'
// El operador '*' (spread operator) "expande" el array como si escribieras: printAll("uno", "dos", "tres")
