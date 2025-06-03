//CAPITULO 37 -Tipo de alias
// 'typealias' crea un alias para un tipo complejo, facilitando su uso y lectura

// Alias para una lista de objetos User
typealias UserList = List<User>

// Alias para una función que recibe un User y un String, y devuelve un Boolean
typealias AuthCallback = (User, String) -> Boolean

// Función que recibe una lista de usuarios (UserList) y un callback de autenticación (AuthCallback)
fun processUsers(users: UserList, callback: AuthCallback) {
    // Aquí iría la implementación para procesar usuarios y aplicar el callback
}
