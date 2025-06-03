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

// Paquete de la capa de datos, donde se define la implementación del repositorio.
package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Implementación de [ItemsRepository] que trabaja con datos almacenados localmente
 * usando Room (sin conexión a internet, de ahí el nombre "Offline").
 *
 * @param itemDao DAO que permite realizar operaciones CRUD sobre la base de datos de ítems.
 */
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {

    /**
     * Recupera todos los ítems de la base de datos local como un flujo reactivo.
     *
     * @return Un [Flow] que emite actualizaciones en tiempo real de la lista de ítems.
     */
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    /**
     * Recupera un ítem específico por su ID desde la base de datos local.
     *
     * @param id ID único del ítem.
     * @return Un [Flow] que emite el ítem correspondiente o null si no existe.
     */
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    /**
     * Inserta un nuevo ítem en la base de datos local.
     *
     * @param item El ítem a insertar.
     */
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    /**
     * Elimina un ítem de la base de datos local.
     *
     * @param item El ítem a eliminar.
     */
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    /**
     * Actualiza la información de un ítem existente en la base de datos local.
     *
     * @param item El ítem con los datos actualizados.
     */
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}