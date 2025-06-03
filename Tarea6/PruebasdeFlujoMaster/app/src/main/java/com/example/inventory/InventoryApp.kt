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

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.inventory

import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventory.R.string
import com.example.inventory.ui.navigation.InventoryNavHost

/**
 * Composable principal de la app.
 * Contiene el NavHost, que maneja la navegación entre pantallas.
 */
@Composable
fun InventoryApp(navController: NavHostController = rememberNavController()) {
    // Llama a la función InventoryNavHost pasando el navController
    InventoryNavHost(navController = navController)
}

/**
 * AppBar personalizado que muestra un título centrado y, si se puede navegar atrás,
 * muestra un botón de "volver" con una flecha.
 */
@Composable
fun InventoryTopAppBar(
    title: String, // Título que se mostrará en el AppBar
    canNavigateBack: Boolean, // Indica si se debe mostrar el botón de "volver"
    modifier: Modifier = Modifier, // Modificador opcional para personalizar el AppBar
    scrollBehavior: TopAppBarScrollBehavior? = null, // Comportamiento de scroll (puede ser nulo)
    navigateUp: () -> Unit = {} // Acción que se ejecuta al presionar el botón de "volver"
) {
    CenterAlignedTopAppBar(
        title = { Text(title) }, // Muestra el título en el centro
        modifier = modifier, // Aplica el modificador si se pasa
        scrollBehavior = scrollBehavior, // Aplica el comportamiento de scroll (si existe)
        navigationIcon = {
            // Solo muestra el botón de "volver" si canNavigateBack es true
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.ArrowBack, // Usa el ícono de flecha hacia atrás
                        contentDescription = stringResource(string.back_button) // Descripción accesible del botón
                    )
                }
            }
        }
    )
}
