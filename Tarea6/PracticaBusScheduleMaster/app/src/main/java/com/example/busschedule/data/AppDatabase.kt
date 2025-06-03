/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Anotación @Database indica que esta clase es la base de datos de Room.
// entities = arrayOf(BusSchedule::class) define que la base contiene una tabla representada por la clase BusSchedule.
// version = 1 es la versión de la base de datos actual.
@Database(entities = arrayOf(BusSchedule::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Método abstracto que permite acceder al DAO (Data Access Object).
    abstract fun busScheduleDao(): BusScheduleDao

    // companion object permite acceder a miembros estáticos (como en Java)
    companion object {
        // INSTANCE es una instancia singleton de la base de datos para evitar múltiples accesos.
        // @Volatile garantiza que los cambios a INSTANCE sean visibles a todos los hilos.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Método para obtener una instancia de la base de datos.
        // Si ya existe una instancia, la devuelve. Si no, la crea de forma sincronizada (segura para hilos múltiples).
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                // Crea una base de datos usando Room.databaseBuilder
                Room.databaseBuilder(
                    context,                   // contexto de la aplicación
                    AppDatabase::class.java,   // clase que representa la base de datos
                    "app_database"             // nombre del archivo de la base de datos
                )
                    // Carga una base de datos preconstruida desde los assets del proyecto
                    .createFromAsset("database/bus_schedule.db")
                    // Si no se encuentra una estrategia de migración, destruye la base y la recrea
                    .fallbackToDestructiveMigration()
                    // build() crea la base y also { } guarda la instancia para uso posterior
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
