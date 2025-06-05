/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia Apache 2.0: Permite el uso, modificación y distribución del código bajo condiciones específicas.
 */
package com.example.cupcake.ui

// Importaciones necesarias para UI con Jetpack Compose y recursos
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.components.FormattedPriceLabel
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Pantalla de resumen del pedido.
 *
 * Muestra los detalles del pedido, incluyendo cantidad, sabor, fecha de recogida y precio.
 *
 * Parámetros:
 * - [orderUiState]: estado actual del pedido (datos seleccionados).
 * - [onCancelButtonClicked]: función que se ejecuta al cancelar el pedido.
 * - [onSendButtonClicked]: función que se ejecuta al compartir el pedido.
 */
@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Accede a los recursos del contexto actual (necesario para obtener strings plurales, etc.)
    val resources = LocalContext.current.resources

    // Obtiene la cadena correspondiente a la cantidad de cupcakes, considerando pluralización
    val numberOfCupcakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )

    // Construye el resumen del pedido como texto formateado con los datos del estado
    val orderSummary = stringResource(
        R.string.order_details,
        numberOfCupcakes,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity
    )

    // Título del mensaje a enviar
    val newOrder = stringResource(R.string.new_cupcake_order)

    // Lista con los datos clave del pedido para mostrar en la UI
    val items = listOf(
        Pair(stringResource(R.string.quantity), numberOfCupcakes),
        Pair(stringResource(R.string.flavor), orderUiState.flavor),
        Pair(stringResource(R.string.pickup_date), orderUiState.date)
    )

    // Diseño principal en columna
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween // Espaciado entre contenido y botones
    ) {
        // Sección superior: muestra la información del pedido
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            // Recorre cada par de datos y los muestra en pantalla
            items.forEach { item ->
                Text(item.first.uppercase()) // Título (cantidad, sabor, etc.)
                Text(text = item.second, fontWeight = FontWeight.Bold) // Valor
                Divider(thickness = dimensionResource(R.dimen.thickness_divider)) // Separador
            }

            // Espacio antes del precio
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

            // Muestra el precio formateado en la esquina inferior derecha
            FormattedPriceLabel(
                subtotal = orderUiState.price,
                modifier = Modifier.align(Alignment.End)
            )
        }

        // Sección inferior: botones para enviar o cancelar
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                // Botón para enviar pedido (comparte los detalles)
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSendButtonClicked(newOrder, orderSummary) }
                ) {
                    Text(stringResource(R.string.send))
                }

                // Botón para cancelar el pedido
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}

/**
 * Vista previa del resumen del pedido (usado en el diseño para testeo visual)
 */
@Preview
@Composable
fun OrderSummaryPreview() {
    CupcakeTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Test", "Test", "$300.00"),
            onSendButtonClicked = { subject: String, summary: String -> },
            onCancelButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}
