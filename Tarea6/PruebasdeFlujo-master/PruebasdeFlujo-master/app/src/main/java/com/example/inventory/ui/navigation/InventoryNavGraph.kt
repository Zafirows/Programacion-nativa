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

package com.example.inventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.inventory.ui.home.HomeDestination
import com.example.inventory.ui.home.HomeScreen
import com.example.inventory.ui.item.ItemDetailsDestination
import com.example.inventory.ui.item.ItemDetailsScreen
import com.example.inventory.ui.item.ItemEditDestination
import com.example.inventory.ui.item.ItemEditScreen
import com.example.inventory.ui.item.ItemEntryDestination
import com.example.inventory.ui.item.ItemEntryScreen

/**
 * Esta función define el grafo de navegación principal de la app.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController, // Controlador de navegación (lo recibe la función)
    modifier: Modifier = Modifier,    // Modificador opcional para aplicar estilo al NavHost
) {
    NavHost(
        navController = navController, // Controlador que maneja la navegación
        startDestination = HomeDestination.route, // Ruta/pantalla inicial al abrir la app
        modifier = modifier // Se aplica el modificador si se pasa
    ) {

        // Pantalla principal de inicio (Home)
        composable(route = HomeDestination.route) {
            HomeScreen(
                // Al pulsar "agregar nuevo ítem", navega a la pantalla de entrada
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                // Al pulsar un ítem existente, navega a la pantalla de detalles pasándole el ID
                navigateToItemUpdate = {
                    navController.navigate("${ItemDetailsDestination.route}/${it}")
                }
            )
        }

        // Pantalla para crear un nuevo ítem
        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(
                // Al pulsar "guardar" o "cancelar", vuelve a la pantalla anterior
                navigateBack = { navController.popBackStack() },
                // Al pulsar el botón "arriba" (flecha de retroceso), navega hacia atrás
                onNavigateUp = { navController.navigateUp() }
            )
        }

        // Pantalla de detalles del ítem seleccionado
        composable(
            route = ItemDetailsDestination.routeWithArgs, // Ruta con argumentos (ID del ítem)
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType // El argumento es un entero
            })
        ) {
            ItemDetailsScreen(
                // Al pulsar "editar", navega a la pantalla de edición pasándole el ID
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                // Al pulsar atrás, regresa
                navigateBack = { navController.navigateUp() }
            )
        }

        // Pantalla para editar un ítem existente
        composable(
            route = ItemEditDestination.routeWithArgs, // Ruta con argumentos (ID del ítem)
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType // El argumento es un entero
            })
        ) {
            ItemEditScreen(
                // Al guardar o cancelar, vuelve a la pantalla anterior
                navigateBack = { navController.popBackStack() },
                // Al pulsar el botón "arriba", navega hacia atrás
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}