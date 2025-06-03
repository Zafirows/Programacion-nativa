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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventory.InventoryTopAppBar
import com.example.inventory.R
import com.example.inventory.data.Item
import com.example.inventory.ui.AppViewModelProvider
import com.example.inventory.ui.item.formatedPrice
import com.example.inventory.ui.navigation.NavigationDestination
import com.example.inventory.ui.theme.InventoryTheme

// Objeto que define la configuración de navegación hacia la pantalla Home
object HomeDestination : NavigationDestination {
    override val route = "home" // Ruta de navegación
    override val titleRes = R.string.app_name // Título mostrado en la barra superior
}

/**
 * Pantalla principal (HomeScreen) que muestra la lista de productos.
 * Incluye un botón para añadir nuevos ítems y permite navegar a editar ítems existentes.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit, // Acción al presionar FAB (añadir ítem)
    navigateToItemUpdate: (Int) -> Unit, // Acción al seleccionar un ítem (editar)
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    // Obtenemos el estado de la UI (lista de productos)
    val homeUiState by viewModel.homeUiState.collectAsState()
    // Configuración de la barra superior con scroll dinámico
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    // Scaffold organiza la estructura de la pantalla (TopBar, FAB, Contenido)
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection), // Soporta scroll del AppBar
        topBar = {
            InventoryTopAppBar(
                title = stringResource(HomeDestination.titleRes), // Título de la app
                canNavigateBack = false, // No muestra botón de "atrás"
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry, // Acción para crear un nuevo ítem
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add, // Ícono de suma "+"
                    contentDescription = stringResource(R.string.item_entry_title) // Accesibilidad
                )
            }
        },
    ) { innerPadding ->
        // Cuerpo de la pantalla que muestra la lista de ítems o un mensaje si está vacía
        HomeBody(
            itemList = homeUiState.itemList,
            onItemClick = navigateToItemUpdate,
            modifier = modifier.padding(innerPadding)
        )
    }
}

/**
 * Cuerpo principal de la pantalla.
 * Muestra la lista de ítems o un mensaje si no hay productos en stock.
 */
@Composable
private fun HomeBody(
    itemList: List<Item>, // Lista de productos a mostrar
    onItemClick: (Int) -> Unit, // Acción al hacer clic en un ítem
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        if (itemList.isEmpty()) {
            // Si no hay productos, mostrar mensaje informativo
            Text(
                text = stringResource(R.string.no_item_description),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(contentPadding),
            )
        } else {
            // Mostrar la lista de productos
            InventoryList(
                itemList = itemList,
                onItemClick = { onItemClick(it.id) }, // Llama al callback pasando el ID del ítem
                contentPadding = contentPadding,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

/**
 * Muestra la lista de productos usando LazyColumn para mejor rendimiento.
 */
@Composable
private fun InventoryList(
    itemList: List<Item>,
    onItemClick: (Item) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        // Por cada producto, se dibuja un InventoryItem
        items(items = itemList, key = { it.id }) { item ->
            InventoryItem(
                item = item,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onItemClick(item) } // Al hacer clic, llama al callback
            )
        }
    }
}

/**
 * Muestra la tarjeta de un producto individual (nombre, precio y stock).
 */
@Composable
private fun InventoryItem(
    item: Item,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Elevación de la tarjeta
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth() // Fila para nombre y precio
            ) {
                Text(
                    text = item.name, // Nombre del producto
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f)) // Espacio flexible entre textos
                Text(
                    text = item.formatedPrice(), // Precio formateado (ej. $100.00)
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = stringResource(R.string.in_stock, item.quantity), // Muestra la cantidad disponible
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

//////////////////////////
// PREVIEWS PARA DISEÑO //
//////////////////////////

// Vista previa de la Home con productos cargados
@Preview(showBackground = true)
@Composable
fun HomeBodyPreview() {
    InventoryTheme {
        HomeBody(
            listOf(
                Item(1, "Game", 100.0, 20),
                Item(2, "Pen", 200.0, 30),
                Item(3, "TV", 300.0, 50)
            ),
            onItemClick = {}
        )
    }
}

// Vista previa de la Home sin productos (lista vacía)
@Preview(showBackground = true)
@Composable
fun HomeBodyEmptyListPreview() {
    InventoryTheme {
        HomeBody(
            listOf(),
            onItemClick = {}
        )
    }
}

// Vista previa de un solo producto en su tarjeta
@Preview(showBackground = true)
@Composable
fun InventoryItemPreview() {
    InventoryTheme {
        InventoryItem(
            Item(1, "Game", 100.0, 20),
            )
        }
}