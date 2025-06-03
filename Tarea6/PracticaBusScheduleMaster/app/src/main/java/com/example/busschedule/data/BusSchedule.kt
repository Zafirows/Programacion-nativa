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

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa una sola tabla en la base de datos. Cada fila es una instancia separada de
 * la clase BusSchedule. Cada propiedad corresponde a una columna en la base de datos.
 * Además, se necesita un ID como identificador único para
 * cada fila en la base de datos.
 */
@Entity(tableName = "Schedule") // Define la entidad y el nombre de la tabla en la base de datos.
data class BusSchedule(
    // La propiedad 'id' será la clave primaria de la tabla. Room utilizará esta propiedad
    // para identificar de manera única cada fila.
    @PrimaryKey
    val id: Int,

    // La propiedad 'stopName' es el nombre de la parada de bus. La anotación @NonNull
    // garantiza que no puede ser nulo en la base de datos. 'ColumnInfo' especifica el nombre
    // de la columna en la base de datos.
    @NonNull
    @ColumnInfo(name = "stop_name")
    val stopName: String,

    // La propiedad 'arrivalTimeInMillis' representa el tiempo de llegada del bus en milisegundos.
    // También está marcada como @NonNull, lo que significa que no puede ser nula en la base de datos.
    // 'ColumnInfo' especifica el nombre de la columna en la base de datos.
    @NonNull
    @ColumnInfo(name = "arrival_time")
    val arrivalTimeInMillis: Int
)
