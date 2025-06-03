package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Clase abstracta que define la base de datos Room de la aplicación.
 *
 * - Usa la entidad [Item] como tabla de la base de datos.
 * - Singleton para asegurar que solo exista una instancia de la base de datos en toda la app.
 */
@Database(
    entities = [Item::class], // Entidades que representan las tablas de la base de datos.
    version = 1,               // Versión de la base de datos.
    exportSchema = false       // No exporta el esquema de la base de datos (para simplificar).
)
abstract class InventoryDatabase : RoomDatabase() {

    /**
     * Método abstracto que proporciona acceso al DAO de la entidad Item.
     */
    abstract fun itemDao(): ItemDao

    companion object {
        // Volatile asegura que los cambios a esta variable se reflejan inmediatamente en todos los hilos.
        @Volatile
        private var Instance: InventoryDatabase? = null

        /**
         * Método que devuelve la instancia de la base de datos.
         * Si no existe, la crea de forma segura (thread-safe).
         *
         * @param context Contexto de la aplicación.
         * @return Instancia única de InventoryDatabase.
         */
        fun getDatabase(context: Context): InventoryDatabase {
            // Si la instancia ya existe, se devuelve directamente.
            // Si no, se crea de forma sincronizada.
            return Instance ?: synchronized(this) {
                // Construye la base de datos con Room.
                Room.databaseBuilder(
                    context, // Contexto de la app.
                    InventoryDatabase::class.java, // Clase de la base de datos.
                    "item_database" // Nombre del archivo de la base de datos.
                )
                    .build() // Construye la instancia.
                    .also { Instance = it } // Guarda la instancia creada para futuras llamadas.
            }
            }
        }
}