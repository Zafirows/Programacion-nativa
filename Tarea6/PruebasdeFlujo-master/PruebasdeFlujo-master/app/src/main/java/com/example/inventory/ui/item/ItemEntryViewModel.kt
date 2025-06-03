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

// Paquete correspondiente a la gestión de la lógica y estado de la pantalla de ítems.
package com.example.inventory.ui.item

// Importaciones necesarias para manejar estado en Compose y la lógica de negocio.
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item
import java.text.NumberFormat
import com.example.inventory.data.ItemsRepository


/**
 * ViewModel responsable de validar y guardar ítems en la base de datos Room.
 * También administra el estado de la UI del formulario de entrada de ítems.
 */
class ItemEntryViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    /**
     * Estado actual de la UI para la pantalla de registro de ítems.
     *
     * - Se usa mutableStateOf para que Compose observe los cambios.
     * - Se mantiene privado el setter para evitar modificaciones externas.
     */
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    /**
     * Actualiza el estado de la UI con los nuevos valores de [itemDetails].
     * También realiza validación de los campos.
     */
    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState = ItemUiState(
            itemDetails = itemDetails,
            isEntryValid = validateInput(itemDetails) // Valida si los campos son correctos.
        )
    }

    /**
     * Valida que los campos de entrada no estén vacíos.
     *
     * @param uiState Estado actual de los detalles del ítem.
     * @return true si todos los campos son válidos, false en caso contrario.
     */
    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }

    /**
     * Guarda el ítem en la base de datos si la entrada es válida.
     *
     * Esta función es suspendida porque realiza operaciones en la base de datos.
     */
    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }
}

/**
 * Modelo de estado de la UI para el formulario de entrada de ítems.
 *
 * @param itemDetails Detalles del ítem que se está registrando.
 * @param isEntryValid Indica si los campos actuales del formulario son válidos.
 */
data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

/**
 * Modelo que representa los detalles de un ítem en formato de String,
 * ideal para manejar entradas de texto en la UI.
 */
data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = ""
)

/**
 * Extensión que convierte [ItemDetails] a la entidad [Item].
 * Si los valores de price o quantity no son válidos, se asignan valores por defecto (0.0 y 0).
 */
fun ItemDetails.toItem(): Item = Item(
    id = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0, // Si no es un número válido, asigna 0.0
    quantity = quantity.toIntOrNull() ?: 0 // Si no es un número válido, asigna 0
)

/**
 * Extensión que formatea el precio de un [Item] al formato de moneda local.
 *
 * Ejemplo: 100.0 -> $100.00 (dependiendo de la configuración regional).
 */
fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

/**
 * Extensión que convierte un [Item] a [ItemUiState].
 *
 * @param isEntryValid Indica si la entrada es válida en la UI.
 */
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extensión que convierte un [Item] a [ItemDetails], útil para cargar los datos
 * existentes en los campos de texto del formulario de edición.
 */
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    name = name,
    price = price.toString(),
    quantity = quantity.toString()
)

