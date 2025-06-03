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

// Paquete que contiene la lógica y estado de la pantalla de edición de ítems.
package com.example.inventory.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.ItemsRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * ViewModel responsable de recuperar y actualizar un ítem en la base de datos usando [ItemsRepository].
 */
class ItemEditViewModel(
    savedStateHandle: SavedStateHandle,             // Permite acceder a los argumentos de navegación (como el ID del ítem).
    private val itemsRepository: ItemsRepository    // Repositorio de acceso a la base de datos.
) : ViewModel() {

    /**
     * Estado actual del formulario de edición de ítems.
     *
     * - Se usa mutableStateOf para que Compose observe los cambios.
     * - Setter privado para evitar modificaciones externas.
     */
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    // Recupera el ID del ítem que se está editando, desde los argumentos de navegación.
    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    // Inicializa el ViewModel cargando los datos del ítem desde la base de datos.
    init {
        viewModelScope.launch {
            // Obtiene el ítem de la base de datos y lo convierte al estado de la UI.
            itemUiState = itemsRepository.getItemStream(itemId)
                .filterNotNull()       // Ignora valores nulos (si no se encuentra el ítem).
                .first()               // Recupera el primer valor emitido (la versión actual del ítem).
                .toItemUiState(true)   // Marca la entrada como válida y la convierte al estado de la UI.
        }
    }

    /**
     * Actualiza el ítem en la base de datos, solo si los datos ingresados son válidos.
     */
    suspend fun updateItem() {
        if (validateInput(itemUiState.itemDetails)) {
            // Guarda los cambios en la base de datos.
            itemsRepository.updateItem(itemUiState.itemDetails.toItem())
        }
    }

    /**
     * Actualiza el estado de la UI con los nuevos datos ingresados en el formulario.
     * También valida los datos para habilitar o deshabilitar el botón de guardado.
     */
    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState = ItemUiState(
            itemDetails = itemDetails,
            isEntryValid = validateInput(itemDetails) // Verifica si los campos están completos.
        )
    }

    /**
     * Valida que los campos de entrada no estén vacíos.
     *
     * @return true si todos los campos son válidos, false en caso contrario.
     */
    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
            }
        }
}