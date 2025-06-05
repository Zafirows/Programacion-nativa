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

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.EntreeItem

/**
 * Pantalla para mostrar el menú de entradas (entrees).
 *
 * @param options lista de opciones de entradas disponibles para seleccionar.
 * @param onCancelButtonClicked callback que se ejecuta cuando se presiona el botón cancelar.
 * @param onNextButtonClicked callback que se ejecuta cuando se presiona el botón siguiente.
 * @param onSelectionChanged callback que se ejecuta cuando cambia la selección de la entrada.
 * @param modifier modificador para ajustar el layout desde el caller.
 */
@Composable
fun EntreeMenuScreen(
    options: List<EntreeItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (EntreeItem) -> Unit,
    modifier: Modifier = Modifier
) {
    // Reutiliza la pantalla base para menú, pasando los parámetros necesarios.
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit, // casteo necesario para el tipo general MenuItem
        modifier = modifier
    )
}

/**
 * Preview de la pantalla EntreeMenuScreen para diseño en el IDE.
 */
@Preview
@Composable
fun EntreeMenuPreview(){
    EntreeMenuScreen(
        options = DataSource.entreeMenuItems, // opciones de entrada predefinidas desde el DataSource
        onCancelButtonClicked = {}, // acción vacía para preview
        onNextButtonClicked = {},   // acción vacía para preview
        onSelectionChanged = {},    // acción vacía para preview
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium)) // padding definido en recursos
            .verticalScroll(rememberScrollState()) // permite scroll vertical para la lista de opciones
    )
}
