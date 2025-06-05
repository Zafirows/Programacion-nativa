/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia bajo Apache 2.0: permite el uso y modificación del código bajo condiciones específicas.
 */
package com.example.cupcake.ui

// Importaciones necesarias para Compose y recursos del sistema
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Pantalla de inicio del pedido.
 * Permite al usuario seleccionar la cantidad de cupcakes deseados.
 *
 * @param quantityOptions Lista de pares (Int, Int) donde el primer valor es el ID del string y el segundo la cantidad.
 * @param onNextButtonClicked Callback que se ejecuta con la cantidad seleccionada.
 * @param modifier Modificador opcional para personalizar el diseño.
 */
@Composable
fun StartOrderScreen(
    quantityOptions: List<Pair<Int, Int>>,
    onNextButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween // Distribuye contenido arriba y abajo
    ) {
        // Parte superior: imagen y título
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium))) // Espacio superior
            Image(
                painter = painterResource(R.drawable.cupcake), // Imagen de cupcake
                contentDescription = null, // Imagen decorativa
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = stringResource(R.string.order_cupcakes), // Texto: "Ordena cupcakes"
                style = MaterialTheme.typography.headlineSmall // Estilo grande
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }

        // Parte inferior: botones con opciones de cantidad
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            // Se crea un botón por cada opción de cantidad
            quantityOptions.forEach { item ->
                SelectQuantityButton(
                    labelResourceId = item.first, // ID del string que será el texto del botón
                    onClick = { onNextButtonClicked(item.second) }, // Acción al presionar
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Botón reutilizable que muestra una etiqueta y ejecuta una acción al hacer clic.
 *
 * @param labelResourceId ID del recurso string a mostrar como texto.
 * @param onClick Acción que se ejecuta al hacer clic.
 * @param modifier Modificador para personalizar el botón.
 */
@Composable
fun SelectQuantityButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp) // Asegura un ancho mínimo para el botón
    ) {
        Text(stringResource(labelResourceId)) // Muestra el texto del botón
    }
}

/**
 * Vista previa de esta pantalla en Android Studio.
 * Útil para probar el diseño sin ejecutar la app completa.
 */
@Preview
@Composable
fun StartOrderPreview() {
    CupcakeTheme {
        StartOrderScreen(
            quantityOptions = DataSource.quantityOptions, // Lista de opciones definidas en el archivo de datos
            onNextButtonClicked = {}, // Acción vacía para la vista previa
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}
