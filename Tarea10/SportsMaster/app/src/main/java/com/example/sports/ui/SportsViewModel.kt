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

package com.example.sports.ui

// Importaciones necesarias para el ViewModel y flujos de datos
import androidx.lifecycle.ViewModel
import com.example.sports.data.LocalSportsDataProvider
import com.example.sports.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel para la app de deportes (Sports App)
 */
class SportsViewModel : ViewModel() {

    // Flujo mutable que contiene el estado de la UI
    private val _uiState = MutableStateFlow(
        SportsUiState(
            // Lista de deportes cargada desde el proveedor de datos local
            sportsList = LocalSportsDataProvider.getSportsData(),
            // Deporte actual seleccionado (el primero o uno por defecto)
            currentSport = LocalSportsDataProvider.getSportsData().getOrElse(0) {
                LocalSportsDataProvider.defaultSport
            }
        )
    )

    // Exposición inmutable del estado para la UI
    val uiState: StateFlow<SportsUiState> = _uiState

    // Actualiza el deporte actualmente seleccionado
    fun updateCurrentSport(selectedSport: Sport) {
        _uiState.update {
            it.copy(currentSport = selectedSport)
        }
    }

    // Cambia el estado para mostrar la página de lista
    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    // Cambia el estado para mostrar la página de detalle
    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

// Clase de datos que representa el estado de la UI
data class SportsUiState(
    // Lista de todos los deportes
    val sportsList: List<Sport> = emptyList(),
    // Deporte actual seleccionado
    val currentSport: Sport = LocalSportsDataProvider.defaultSport,
    // Bandera para indicar si se muestra la página de lista (true) o de detalle (false)
    val isShowingListPage: Boolean = true
)
