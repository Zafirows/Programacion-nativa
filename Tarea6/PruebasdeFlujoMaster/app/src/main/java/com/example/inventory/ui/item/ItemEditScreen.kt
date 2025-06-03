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

// Paquete que agrupa las pantallas relacionadas con ítems
package com.example.inventory.ui.item

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventory.InventoryTopAppBar
import com.example.inventory.R
import com.example.inventory.ui.AppViewModelProvider
import com.example.inventory.ui.navigation.NavigationDestination
import com.example.inventory.ui.theme.InventoryTheme
import kotlinx.coroutines.launch

// Objeto que define la navegación hacia la pantalla de edición de ítems
object ItemEditDestination : NavigationDestination {
    override val route = "item_edit" // Ruta base
    override val titleRes = R.string.edit_item_title // Título de la pantalla (desde strings.xml)
    const val itemIdArg = "itemId" // Argumento requerido: ID del ítem a editar
    val routeWithArgs = "$route/{$itemIdArg}" // Ruta incluyendo el argumento
}

// Función principal que construye la pantalla de edición de un ítem
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit, // Acción para volver atrás
    onNavigateUp: () -> Unit, // Acción del botón "arriba" del AppBar
    modifier: Modifier = Modifier, // Modificador externo opcional
    viewModel: ItemEditViewModel = viewModel(factory = AppViewModelProvider.Factory) // ViewModel para manejar el estado
) {
    // Corrutina para tareas como guardar datos
    val coroutineScope = rememberCoroutineScope()

    // Scaffold que contiene barra superior y contenido central
    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(ItemEditDestination.titleRes), // Título de la pantalla
                canNavigateBack = true, // Muestra botón de navegación atrás
                navigateUp = onNavigateUp // Acción al pulsar el botón atrás
            )
        },
        modifier = modifier
    ) { innerPadding ->
        // Cuerpo del formulario de edición
        ItemEntryBody(
            itemUiState = viewModel.itemUiState, // Estado del formulario
            onItemValueChange = viewModel::updateUiState, // Función para actualizar los datos al editar
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateItem() // Llama a la función para guardar cambios
                    navigateBack() // Regresa a la pantalla anterior
                }
            },
            modifier = Modifier
                .padding( // Padding interior según el layout actual
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                )
                .verticalScroll(rememberScrollState()) // Permite hacer scroll si el contenido es largo
        )
    }
}

// Vista previa de diseño de la pantalla de edición (solo para ver en el editor)
@Preview(showBackground = true)
@Composable
fun ItemEditScreenPreview() {
    InventoryTheme {
        ItemEditScreen(navigateBack = { /*Do nothing*/ }, onNavigateUp = { /*Do nothing*/ })
    }
}
