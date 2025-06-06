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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.R

/**
 * Pantalla inicial del pedido.
 * Muestra un botón para comenzar la orden.
 *
 * @param onStartOrderButtonClicked función lambda que se ejecuta cuando se hace clic en el botón.
 * @param modifier modificador opcional para personalizar la apariencia/layout.
 */
@Composable
fun StartOrderScreen(
    onStartOrderButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        // Modificador para aplicar personalizaciones externas como padding o tamaño
        modifier = modifier,
        // Alineación horizontal al centro
        horizontalAlignment = Alignment.CenterHorizontally,
        // Alineación vertical centrada en la pantalla
        verticalArrangement = Arrangement.Center
    ) {
        // Botón que al hacer clic inicia el pedido
        Button(
            onClick = onStartOrderButtonClicked,
            // Define un ancho mínimo para el botón
            Modifier.widthIn(min = 250.dp)
        ) {
            // Texto del botón cargado desde recursos
            Text(stringResource(R.string.start_order))
        }
    }
}

/**
 * Vista previa del componente StartOrderScreen en el editor de diseño.
 */
@Preview
@Composable
fun StartOrderPreview(){
    StartOrderScreen(
        onStartOrderButtonClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium)) // Aplica un padding externo
            .fillMaxSize() // Hace que la pantalla use todo el espacio disponible
    )
}
