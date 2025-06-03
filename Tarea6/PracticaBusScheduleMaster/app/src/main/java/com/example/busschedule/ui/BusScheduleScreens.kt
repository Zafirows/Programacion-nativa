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
package com.example.busschedule.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.busschedule.R
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.ui.theme.BusScheduleTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Enumeración que define las pantallas disponibles en la app
enum class BusScheduleScreens {
    FullSchedule,  // Pantalla con todos los horarios
    RouteSchedule  // Pantalla con horarios de una ruta específica
}

/**
 * Composable principal de la aplicación.
 * @param viewModel ViewModel que maneja la lógica de negocio
 */
@Composable
fun BusScheduleApp(
    viewModel: BusScheduleViewModel = viewModel(factory = BusScheduleViewModel.factory)
) {
    // 1. Controlador de navegación que gestiona el stack de pantallas
    val navController = rememberNavController()

    // 2. Título inicial de la app (usando recursos de strings)
    val fullScheduleTitle = stringResource(R.string.full_schedule)

    // 3. Estado para el título de la TopAppBar (puede cambiar al navegar)
    var topAppBarTitle by remember { mutableStateOf(fullScheduleTitle) }

    // 4. Obtiene el horario completo como un estado observable
    val fullSchedule by viewModel.getFullSchedule().collectAsState(emptyList())

    // 5. Función que maneja el evento de retroceso
    val onBackHandler = {
        topAppBarTitle = fullScheduleTitle  // Restaura el título
        navController.navigateUp()  // Navega a la pantalla anterior
    }

    // 6. Scaffold es la estructura base de la pantalla (con TopAppBar y contenido)
    Scaffold(
        topBar = {
            // 7. Barra superior personalizada
            BusScheduleTopAppBar(
                title = topAppBarTitle,
                canNavigateBack = navController.previousBackStackEntry != null,
                onBackClick = { onBackHandler() }
            )
        }
    ) { innerPadding ->  // Padding interno calculado por Scaffold
        // 8. Sistema de navegación
        NavHost(
            navController = navController,
            startDestination = BusScheduleScreens.FullSchedule.name
        ) {
            // 9. Definición de la pantalla de horario completo
            composable(BusScheduleScreens.FullSchedule.name) {
                FullScheduleScreen(
                    busSchedules = fullSchedule,
                    contentPadding = innerPadding,
                    onScheduleClick = { busStopName ->
                        // 10. Navega a la pantalla de detalle al hacer clic en una ruta
                        navController.navigate(
                            "${BusScheduleScreens.RouteSchedule.name}/$busStopName"
                        )
                        topAppBarTitle = busStopName  // Actualiza el título
                    }
                )
            }

            // 11. Argumento para pasar el nombre de la parada entre pantallas
            val busRouteArgument = "busRoute"

            // 12. Definición de la pantalla de horario por ruta
            composable(
                route = BusScheduleScreens.RouteSchedule.name + "/{$busRouteArgument}",
                arguments = listOf(navArgument(busRouteArgument) { type = NavType.StringType })
            ) { backStackEntry ->
                // 13. Obtiene el nombre de la parada desde los argumentos
                val stopName = backStackEntry.arguments?.getString(busRouteArgument)
                    ?: error("busRouteArgument cannot be null")

                // 14. Obtiene el horario específico para esa parada
                val routeSchedule by viewModel.getScheduleFor(stopName).collectAsState(emptyList())

                // 15. Muestra la pantalla de detalle
                RouteScheduleScreen(
                    stopName = stopName,
                    busSchedules = routeSchedule,
                    contentPadding = innerPadding,
                    onBack = { onBackHandler() }
                )
            }
        }
    }
}

/**
 * Pantalla que muestra todos los horarios disponibles.
 * @param busSchedules Lista de horarios
 * @param onScheduleClick Callback al seleccionar una ruta
 * @param modifier Modificador para personalización
 * @param contentPadding Padding interno
 */
@Composable
fun FullScheduleScreen(
    busSchedules: List<BusSchedule>,
    onScheduleClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    // 16. Reutiliza el componente base pasando el callback
    BusScheduleScreen(
        busSchedules = busSchedules,
        onScheduleClick = onScheduleClick,
        contentPadding = contentPadding,
        modifier = modifier
    )
}

/**
 * Pantalla que muestra los horarios de una ruta específica.
 * @param stopName Nombre de la parada
 * @param busSchedules Lista de horarios para esta parada
 * @param modifier Modificador para personalización
 * @param contentPadding Padding interno
 * @param onBack Callback para el botón de retroceso
 */
@Composable
fun RouteScheduleScreen(
    stopName: String,
    busSchedules: List<BusSchedule>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onBack: () -> Unit = {}
) {
    // 17. Maneja el botón de retroceso físico
    BackHandler { onBack() }

    // 18. Reutiliza el componente base especificando el nombre de la parada
    BusScheduleScreen(
        busSchedules = busSchedules,
        modifier = modifier,
        contentPadding = contentPadding,
        stopName = stopName
    )
}

/**
 * Componente base para mostrar horarios de autobuses.
 * @param busSchedules Lista de horarios
 * @param modifier Modificador para personalización
 * @param contentPadding Padding interno
 * @param stopName Nombre de la parada (opcional)
 * @param onScheduleClick Callback al seleccionar (opcional)
 */
@Composable
fun BusScheduleScreen(
    busSchedules: List<BusSchedule>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    stopName: String? = null,
    onScheduleClick: ((String) -> Unit)? = null,
) {
    // 19. Determina el texto del encabezado según si hay nombre de parada específico
    val stopNameText = if (stopName == null) {
        stringResource(R.string.stop_name)  // Texto genérico
    } else {
        "$stopName ${stringResource(R.string.route_stop_name)}"  // Texto específico
    }

    // 20. Obtiene la dirección del layout (LTR o RTL)
    val layoutDirection = LocalLayoutDirection.current

    // 21. Columna principal que organiza los elementos
    Column(
        modifier = modifier.padding(
            start = contentPadding.calculateStartPadding(layoutDirection),
            end = contentPadding.calculateEndPadding(layoutDirection),
        )
    ) {
        // 22. Fila para los encabezados de las columnas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = contentPadding.calculateTopPadding(),
                    bottom = dimensionResource(R.dimen.padding_medium),
                    start = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium),
                ),
            horizontalArrangement = Arrangement.SpaceBetween  // Espacio entre elementos
        ) {
            Text(stopNameText)  // Encabezado de nombre de parada
            Text(stringResource(R.string.arrival_time))  // Encabezado de hora
        }

        Divider()  // 23. Línea divisoria

        // 24. Componente con la lista de horarios
        BusScheduleDetails(
            contentPadding = PaddingValues(
                bottom = contentPadding.calculateBottomPadding()
            ),
            busSchedules = busSchedules,
            onScheduleClick = onScheduleClick
        )
    }
}

/**
 * Componente que muestra la lista de horarios.
 * @param busSchedules Lista de horarios
 * @param modifier Modificador para personalización
 * @param contentPadding Padding interno
 * @param onScheduleClick Callback al seleccionar (opcional)
 */
@Composable
fun BusScheduleDetails(
    busSchedules: List<BusSchedule>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onScheduleClick: ((String) -> Unit)? = null
) {
    // 25. LazyColumn es una lista eficiente que solo renderiza lo visible
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
    ) {
        // 26. Itera sobre los horarios
        items(
            items = busSchedules,
            key = { busSchedule -> busSchedule.id }  // Clave única para cada item
        ) { schedule ->
            // 27. Fila para cada horario
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = onScheduleClick != null) {
                        // 28. Si hay callback, lo ejecuta al hacer clic
                        onScheduleClick?.invoke(schedule.stopName)
                    }
                    .padding(dimensionResource(R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // 29. Renderizado condicional del nombre de parada
                if (onScheduleClick == null) {
                    // 30. Si no hay callback, muestra un placeholder
                    Text(
                        text = "--",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = dimensionResource(R.dimen.font_large).value.sp,
                            fontWeight = FontWeight(300)
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    // 31. Muestra el nombre real de la parada
                    Text(
                        text = schedule.stopName,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = dimensionResource(R.dimen.font_large).value.sp,
                            fontWeight = FontWeight(300)
                        )
                    )
                }

                // 32. Muestra la hora formateada
                Text(
                    text = SimpleDateFormat("h:mm a", Locale.getDefault())
                        .format(Date(schedule.arrivalTimeInMillis.toLong() * 1000)),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = dimensionResource(R.dimen.font_large).value.sp,
                        fontWeight = FontWeight(600)  // Texto más grueso
                    ),
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(2f)  // Ocupa más espacio
                )
            }
        }
    }
}

/**
 * Barra superior personalizada.
 * @param title Título a mostrar
 * @param canNavigateBack Si muestra el botón de retroceso
 * @param onBackClick Callback para el botón de retroceso
 * @param modifier Modificador para personalización
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusScheduleTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // 33. Renderizado condicional según si debe mostrar botón de retroceso
    if (canNavigateBack) {
        TopAppBar(
            title = { Text(title) },  // Título
            navigationIcon = {
                // 34. Botón de retroceso con icono
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            },
            modifier = modifier
        )
    } else {
        // 35. Barra sin botón de retroceso
        TopAppBar(
            title = { Text(title) },
            modifier = modifier
        )
    }
}

// Previews para Android Studio

@Preview(showBackground = true)
@Composable
fun FullScheduleScreenPreview() {
    BusScheduleTheme {
        FullScheduleScreen(
            busSchedules = List(3) { index ->
                BusSchedule(
                    index,
                    "Main Street",
                    111111
                )
            },
            onScheduleClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RouteScheduleScreenPreview() {
    BusScheduleTheme {
        RouteScheduleScreen(
            stopName = "Main Street",
            busSchedules = List(3) { index ->
                BusSchedule(
                    index,
                    "Main Street",
                    111111
                )
            }
        )
    }
}