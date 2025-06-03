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

package com.example.inventory.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.Item
import com.example.inventory.data.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * ViewModel encargado de recuperar todos los ítems almacenados en la base de datos Room.
 * Proporciona el estado necesario para la UI de la pantalla de inicio (Home).
 */
class HomeViewModel(itemsRepository: ItemsRepository) : ViewModel() {

    /**
     * Estado observable de la UI de la pantalla Home.
     *
     * - Recupera la lista de ítems desde ItemsRepository como un Flow.
     * - Mapea esa lista al objeto HomeUiState.
     * - stateIn convierte el Flow en StateFlow para mantener el último estado emitido,
     *   ideal para su uso con Jetpack Compose.
     */
    val homeUiState: StateFlow<HomeUiState> =
        itemsRepository.getAllItemsStream() // Flujo de datos de la base de datos.
            .map { HomeUiState(it) } // Mapea la lista de ítems a un objeto HomeUiState.
            .stateIn(
                scope = viewModelScope, // El ciclo de vida del flujo está vinculado al ViewModel.
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS), // Mantiene activo el flujo 5 segundos tras la última suscripción.
                initialValue = HomeUiState() // Valor inicial: lista vacía.
            )

    companion object {
        // Tiempo en milisegundos que se mantendrá activo el flujo después de perder suscriptores.
        private const val TIMEOUT_MILLIS = 5_000L // 5 segundos.
    }
}

/**
 * Modelo de estado de la UI para la pantalla Home.
 *
 * @param itemList Lista de productos a mostrar. Por defecto, la lista está vacía.
 */
data class HomeUiState(val itemList: List<Item> = listOf())