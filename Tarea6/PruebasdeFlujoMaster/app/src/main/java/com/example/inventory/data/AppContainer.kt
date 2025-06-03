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

// Paquete de la capa de datos, encargado de la gestión de dependencias.
package com.example.inventory.data

import android.content.Context

/**
 * Interfaz que define un contenedor de dependencias (Dependency Injection Container).
 *
 * Cualquier clase que implemente esta interfaz deberá proporcionar
 * una instancia de [ItemsRepository].
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * Implementación concreta de [AppContainer] que configura y proporciona
 * las dependencias necesarias para la app, utilizando la implementación Offline (local).
 *
 * @param context Contexto de la aplicación, necesario para inicializar la base de datos Room.
 */
class AppDataContainer(private val context: Context) : AppContainer {

    /**
     * Implementación perezosa (lazy) de [ItemsRepository].
     *
     * - Se instancia una sola vez cuando es requerida por primera vez.
     * - Usa la base de datos local [InventoryDatabase] y el DAO [ItemDao].
     */
    override val itemsRepository: ItemsRepository by lazy {
        // Obtiene la instancia de la base de datos y su DAO para crear el repositorio offline.
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
        }
}