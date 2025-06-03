/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Paquete donde se agrupan las clases relacionadas con los datos (modelo, base de datos, etc.)
package com.example.inventory.data


/**
 * Esta clase representa una entidad (tabla) en la base de datos.
 * Cada instancia de esta clase representa una fila de la tabla "items".
 */

import androidx.room.Entity // Anotación para definir una entidad Room
import androidx.room.PrimaryKey // Anotación para indicar la clave primaria de la tabla

// Anotación que marca esta clase como una tabla en la base de datos Room.
// "items" será el nombre de la tabla en SQLite.
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) // Clave primaria que se autogenera
    val id: Int = 0,                 // ID único de cada ítem (autoincremental)
    val name: String,                // Nombre del producto
    val price: Double,               // Precio del producto
    val quantity: Int                // Cantidadenstock
)