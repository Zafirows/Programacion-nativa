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

// Paquete de la capa de datos, donde se definen entidades, DAOs y repositorios.
package com.example.inventory.data

// Importa Flow de Kotlin Coroutines para manejar flujos de datos reactivos.
import kotlinx.coroutines.flow.Flow

/**
 * Interfaz que define las operaciones básicas para administrar los ítems de inventario.
 *
 * Proporciona métodos para:
 * - Insertar
 * - Actualizar
 * - Eliminar
 * - Consultar (individual o lista completa)
 *
 * Esta interfaz permite desacoplar la lógica de acceso a datos de la lógica de la UI o ViewModels.
 */
interface ItemsRepository {

    /**
     * Recupera todos los ítems de la fuente de datos como un flujo reactivo (Flow).
     *
     * @return Flow que emite actualizaciones con la lista de ítems en tiempo real.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Recupera un ítem específico a partir de su ID.
     *
     * @param id Identificador único del ítem.
     * @return Flow que emite actualizaciones con el ítem correspondiente, o null si no existe.
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Inserta un nuevo ítem en la fuente de datos.
     *
     * @param item Objeto Item que se desea insertar.
     */
    suspend fun insertItem(item: Item)

    /**
     * Elimina un ítem de la fuente de datos.
     *
     * @param item Objeto Item que se desea eliminar.
     */
    suspend fun deleteItem(item: Item)

    /**
     * Actualiza un ítem existente en la fuente de datos.
     *
     * @param item Objeto Item con los nuevos datos actualizados.
     */
    suspend fun updateItem(item:Item)
}