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

package com.example.lunchtray.ui

import androidx.lifecycle.ViewModel
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem
import com.example.lunchtray.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

// ViewModel para manejar el estado de la orden del usuario
class OrderViewModel : ViewModel() {

    // Tasa de impuesto fija del 8%
    private val taxRate = 0.08

    // Estado interno mutable que mantiene el estado de la UI
    private val _uiState = MutableStateFlow(OrderUiState())
    // Estado público inmutable que expone el estado para la UI
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    // Actualiza la entrada principal del pedido
    fun updateEntree(entree: EntreeItem) {
        val previousEntree = _uiState.value.entree
        updateItem(entree, previousEntree)
    }

    // Actualiza el acompañamiento lateral del pedido
    fun updateSideDish(sideDish: SideDishItem) {
        val previousSideDish = _uiState.value.sideDish
        updateItem(sideDish, previousSideDish)
    }

    // Actualiza el acompañamiento adicional del pedido
    fun updateAccompaniment(accompaniment: AccompanimentItem) {
        val previousAccompaniment = _uiState.value.accompaniment
        updateItem(accompaniment, previousAccompaniment)
    }

    // Reinicia el estado del pedido a su estado inicial (vacío)
    fun resetOrder() {
        _uiState.value = OrderUiState()
    }

    /**
     * Actualiza un ítem del pedido, reemplazando el anterior de la misma categoría
     * y recalculando los precios totales y los impuestos.
     *
     * @param newItem el nuevo ítem seleccionado
     * @param previousItem el ítem previamente seleccionado (si existe)
     */
    private fun updateItem(newItem: MenuItem, previousItem: MenuItem?) {
        _uiState.update { currentState ->
            // Precio del ítem anterior, 0 si no existía ninguno
            val previousItemPrice = previousItem?.price ?: 0.0
            // Se resta el precio anterior y se suma el del nuevo ítem para obtener el total actualizado
            val itemTotalPrice = currentState.itemTotalPrice - previousItemPrice + newItem.price
            // Cálculo del impuesto basado en el total actualizado
            val tax = itemTotalPrice * taxRate
            // Se retorna una copia del estado actualizado con los nuevos valores
            currentState.copy(
                itemTotalPrice = itemTotalPrice,
                orderTax = tax,
                orderTotalPrice = itemTotalPrice + tax,
                // Actualiza el ítem correspondiente según su tipo
                entree = if (newItem is EntreeItem) newItem else currentState.entree,
                sideDish = if (newItem is SideDishItem) newItem else currentState.sideDish,
                accompaniment =
                    if (newItem is AccompanimentItem) newItem else currentState.accompaniment
            )
        }
    }
}

/**
 * Extensión para formatear un número Double como precio monetario
 * según la configuración regional actual.
 */
fun Double.formatPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}
