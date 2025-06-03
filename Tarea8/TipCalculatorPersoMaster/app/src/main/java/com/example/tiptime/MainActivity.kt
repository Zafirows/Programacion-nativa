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
package com.example.tiptime

import android.os.Bundle
import androidx.compose.material3.Switch
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.input.ImeAction
import androidx.annotation.StringRes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat

// Clase principal de la app, extiende de ComponentActivity para usar Jetpack Compose
class MainActivity : ComponentActivity() {
    // Método que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita diseño de pantalla completa (de borde a borde)
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme { // Aplica el tema de la app
                Surface(
                    modifier = Modifier.fillMaxSize(), // Hace que ocupe todo el tamaño disponible
                ) {
                    TipTimeLayout() // Muestra el contenido principal de la app
                }
            }
        }
    }
}

// Función composable que define el layout de la calculadora de propinas
@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") } // Estado para el monto ingresado
    var tipInput by remember { mutableStateOf("") } // Estado para el porcentaje de propina
    var roundUp by remember { mutableStateOf(false) } // Estado para saber si redondear la propina

    // Convierte los textos ingresados a números (Double), usa 0.0 si el valor es inválido
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0

    // Calcula la propina
    val tip = calculateTip(amount, tipPercent, roundUp)

    // Columna principal con padding y scroll
    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título "Calculate Tip"
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )

        // Campo para ingresar el monto de la cuenta
        EditNumberField(
            label = R.string.bill_amount, // Etiqueta
            leadingIcon = R.drawable.money, // Ícono de dinero
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number, // Solo números
                imeAction = ImeAction.Next // Acción "Siguiente" en el teclado
            ),
            value = amountInput, // Valor actual del input
            onValueChanged = { amountInput = it }, // Actualiza el estado al cambiar
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        // Campo para ingresar el porcentaje de propina
        EditNumberField(
            label = R.string.how_was_the_service, // Etiqueta
            leadingIcon = R.drawable.percent, // Ícono de porcentaje
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done // Acción "Hecho" en el teclado
            ),
            value = tipInput,
            onValueChanged = { tipInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        // Fila con switch para redondear la propina
        RoundTheTipRow(
            roundUp = roundUp, // Estado actual
            onRoundUpChanged = { roundUp = it }, // Se actualiza al cambiar el switch
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Texto que muestra la propina calculada
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )

        // Espaciado extra al final
        Spacer(modifier = Modifier.height(150.dp))
    }
}

// Composable para un campo de texto con ícono y etiqueta
@Composable
fun EditNumberField(
    @StringRes label: Int, // Etiqueta del campo (recurso de string)
    @DrawableRes leadingIcon: Int, // Ícono al inicio del campo
    keyboardOptions: KeyboardOptions, // Configuración del teclado
    value: String, // Valor actual del campo
    onValueChanged: (String) -> Unit, // Callback cuando cambia el valor
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions
    )
}

// Composable para mostrar la opción de redondear la propina con un switch
@Composable
fun RoundTheTipRow(
    roundUp: Boolean, // Estado actual del switch
    onRoundUpChanged: (Boolean) -> Unit, // Callback cuando se cambia el switch
    modifier: Modifier = Modifier
) {
    Text(text = stringResource(R.string.round_up_tip)) // Texto descriptivo
    Switch(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End), // Alinea a la derecha
        checked = roundUp, // Valor actual del switch
        onCheckedChange = onRoundUpChanged, // Se actualiza al cambiar
    )
}

// Función que calcula y formatea la propina según el monto y porcentaje ingresado
private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount // Calcula la propina base
    if (roundUp) {
        tip = kotlin.math.ceil(tip) // Redondea hacia arriba si es necesario
    }
    return NumberFormat.getCurrencyInstance().format(tip) // Devuelve la propina formateada
}

// Vista previa de TipTimeLayout en modo diseño
@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    TipTimeTheme {
        TipTimeLayout() // Muestra la vista previa con el tema aplicado
    }
}
