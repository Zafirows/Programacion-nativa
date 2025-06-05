/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia Apache 2.0: Permite el uso, modificación y distribución del código bajo ciertas condiciones.
 */
package com.example.cupcake.ui

// Importaciones necesarias para crear interfaces con Jetpack Compose
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.ui.components.FormattedPriceLabel
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Pantalla de selección de opciones con botones de radio.
 *
 * Parámetros:
 * - [subtotal]: precio actual mostrado al usuario.
 * - [options]: lista de opciones disponibles (por ejemplo: sabores o fechas).
 * - [onSelectionChanged]: callback que se ejecuta cuando el usuario selecciona una opción.
 * - [onCancelButtonClicked]: callback al hacer clic en "Cancelar".
 * - [onNextButtonClicked]: callback al hacer clic en "Siguiente".
 * - [modifier]: modificador opcional para la personalización del diseño.
 */
@Composable
fun SelectOptionScreen(
    subtotal: String,
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    // Estado para guardar cuál opción ha sido seleccionada por el usuario
    var selectedValue by rememberSaveable { mutableStateOf("") }

    // Diseño principal en columna, con espacio entre la sección de opciones y los botones
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Columna para mostrar todas las opciones disponibles
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            // Por cada opción, se crea un elemento con botón de radio y texto
            options.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botón de radio que se activa si la opción está seleccionada
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }

            // Línea divisoria entre las opciones y el precio
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )

            // Componente personalizado que muestra el subtotal alineado a la derecha
            FormattedPriceLabel(
                subtotal = subtotal,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
            )
        }

        // Fila inferior con botones de acción
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            // Botón para cancelar la orden
            OutlinedButton(
                modifier = Modifier.weight(1f), // Ambos botones ocupan el mismo ancho
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }

            // Botón para continuar (solo habilitado si se seleccionó una opción)
            Button(
                modifier = Modifier.weight(1f),
                enabled = selectedValue.isNotEmpty(),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

/**
 * Vista previa de la pantalla de selección de opciones.
 * Útil para verificar visualmente cómo se verá la pantalla en Android Studio.
 */
@Preview
@Composable
fun SelectOptionPreview() {
    CupcakeTheme {
        SelectOptionScreen(
            subtotal = "299.99",
            options = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
            modifier = Modifier.fillMaxHeight()
        )
    }
}
