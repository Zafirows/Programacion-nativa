// Paquete de la capa de datos, donde se definen las operaciones de acceso a la base de datos
package com.example.inventory.data

// Importaciones necesarias para Room y Flows de Kotlin
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// @Dao indica que esta interfaz es un Data Access Object para Room
@Dao
interface ItemDao {

    // Inserta un nuevo ítem en la base de datos.
    // Si ya existe un ítem con el mismo ID, ignora la operación (no reemplaza).
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item) // suspend para ejecución en corrutinas (hilo no principal)

    // Actualiza un ítem existente en la base de datos.
    @Update
    suspend fun update(item: Item)

    // Elimina un ítem de la base de datos.
    @Delete
    suspend fun delete(item: Item)

    // Recupera un ítem por su ID.
    // Retorna un Flow para obtener actualizaciones en tiempo real de los cambios en ese ítem.
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Obtiene todos los ítems de la base de datos, ordenados alfabéticamente por nombre.
    // Retorna un Flow para que la UI se actualice automáticamente ante cambios.
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}
