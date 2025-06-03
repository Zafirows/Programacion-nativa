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

// Paquete que contiene utilidades y configuraciones globales de la app.
package com.example.inventory.ui


// Importaciones necesarias para la creación de ViewModels y gestión de estado.
import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.inventory.InventoryApplication
import com.example.inventory.ui.home.HomeViewModel
import com.example.inventory.ui.item.ItemDetailsViewModel
import com.example.inventory.ui.item.ItemEditViewModel
import com.example.inventory.ui.item.ItemEntryViewModel

/**
 * Objeto que proporciona una factoría de ViewModels para toda la aplicación.
 *
 * Utiliza la API moderna de viewModelFactory para inicializar ViewModels de forma centralizada
 * y manejar la inyección de dependencias (repositorios) de forma sencilla.
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Inicializador para ItemEditViewModel (Pantalla de Edición de Ítems)
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle(), // Proporciona SavedStateHandle para manejar estados persistentes.
                inventoryApplication().container.itemsRepository // Inyección del repositorio de ítems.
            )
        }

        // Inicializador para ItemEntryViewModel (Pantalla de Creación de Ítems)
        initializer {
            ItemEntryViewModel(
                inventoryApplication().container.itemsRepository // Inyección del repositorio de ítems.
            )
        }

        // Inicializador para ItemDetailsViewModel (Pantalla de Detalles de Ítems)
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle(), // Permite recuperar argumentos de navegación seguros.
                inventoryApplication().container.itemsRepository
            )
        }

        // Inicializador para HomeViewModel (Pantalla Principal/Home)
        initializer {
            HomeViewModel(
                inventoryApplication().container.itemsRepository
            )
        }
    }
}

/**
 * Función de extensión que permite acceder a la instancia de [InventoryApplication]
 * desde CreationExtras.
 *
 * Esto facilita obtener el contenedor de dependencias configurado en la clase Application.
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)