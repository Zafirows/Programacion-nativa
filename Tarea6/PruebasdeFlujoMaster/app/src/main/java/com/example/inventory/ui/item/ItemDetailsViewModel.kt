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

// Paquete correspondiente a la gestión de la lógica y estado de la pantalla de detalles de ítems.
package com.example.inventory.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * ViewModel responsable de recuperar, actualizar y eliminar un ítem
 * desde la fuente de datos proporcionada por [ItemsRepository].
 */
class ItemDetailsViewModel(
    savedStateHandle: SavedStateHandle,              // Permite recuperar parámetros de navegación de forma segura.
    private val itemsRepository: ItemsRepository     // Repositorio de acceso a la base de datos.
) : ViewModel() {

    // Recupera el ID del ítem desde los argumentos de navegación.
    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

    /**
     * Estado observable de la UI de la pantalla de detalles.
     *
     * - Obtiene el ítem desde el repositorio como un Flow.
     * - Lo transforma en un objeto [ItemDetailsUiState].
     * - Usa StateFlow para mantener el estado actual.
     */
    val uiState: StateFlow<ItemDetailsUiState> =
        itemsRepository.getItemStream(itemId)    // Recupera el flujo de datos del ítem.
            .filterNotNull()                     // Filtra nulos (en caso de que no exista el ítem).
            .map { item ->
                ItemDetailsUiState(
                    outOfStock = item.quantity <= 0, // Evalúa si el producto está agotado.
                    itemDetails = item.toItemDetails() // Convierte a un modelo amigable para la UI.
                )
            }.stateIn(
                scope = viewModelScope,                   // Ciclo de vida del flujo ligado al ViewModel.
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS), // Mantiene el flujo activo por 5 seg tras perder suscriptores.
                initialValue = ItemDetailsUiState()       // Valor inicial por defecto.
            )

    /**
     * Reduce en uno la cantidad del producto, y actualiza la base de datos.
     *
     * Si la cantidad ya es 0, no realiza ningún cambio.
     */
    fun reduceQuantityByOne() {
        viewModelScope.launch {
            val currentItem = uiState.value.itemDetails.toItem() // Recupera el ítem actual.
            if (currentItem.quantity > 0) {
                // Actualiza la base de datos restando 1 a la cantidad.
                itemsRepository.updateItem(currentItem.copy(quantity = currentItem.quantity - 1))
            }
        }
    }

    /**
     * Elimina el ítem actual de la base de datos.
     */
    suspend fun deleteItem() {
        itemsRepository.deleteItem(uiState.value.itemDetails.toItem())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L // Tiempo en milisegundos para mantener activo el flujo tras perder suscriptores.
    }
}

/**
 * Modelo de estado de la UI para la pantalla de detalles de un ítem.
 *
 * @param outOfStock Indica si el producto está agotado.
 * @param itemDetails Detalles del producto mostrados en la UI.
 */
data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val itemDetails: ItemDetails =ItemDetails()
)