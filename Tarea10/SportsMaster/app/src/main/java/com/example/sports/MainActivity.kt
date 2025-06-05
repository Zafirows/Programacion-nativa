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

package com.example.sports

// Importaciones necesarias para Compose y configuración de ventana
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.example.sports.ui.SportsApp
import com.example.sports.ui.theme.SportsTheme

/**
 * Actividad principal de la aplicación Sports
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class) // Anotación para usar APIs experimentales de tamaño de ventana
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Habilita el modo de contenido hasta los bordes (pantalla completa)
        super.onCreate(savedInstanceState)
        setContent {
            // Se establece el tema personalizado de la app
            SportsTheme {
                // Se obtiene la dirección de diseño (LTR o RTL)
                val layoutDirection = LocalLayoutDirection.current
                // Surface es un contenedor visual de fondo con color o estilo
                Surface(
                    modifier = Modifier
                        .padding(
                            // Se agrega padding desde los bordes seguros (safe drawing)
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    // Calcula la clase de tamaño de ventana (Compact, Medium, Expanded)
                    val windowSize = calculateWindowSizeClass(this)
                    // Se lanza la interfaz principal de la app pasando el tamaño y acción al volver atrás
                    SportsApp(
                        windowSize = windowSize.widthSizeClass,
                        onBackPressed = { finish() } // Finaliza la actividad cuando se pulsa atrás
                    )
                }
            }
        }
    }
}
