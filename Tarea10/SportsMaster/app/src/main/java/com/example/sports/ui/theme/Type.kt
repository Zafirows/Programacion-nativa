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

package com.example.sports.ui.theme

// Importaciones necesarias para definir estilos tipográficos en Jetpack Compose
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Conjunto de estilos tipográficos de Material 3 con los valores predeterminados personalizados
val Typography = Typography(
    // Se define el estilo "bodyLarge", que se usa comúnmente para el texto principal
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,         // Familia tipográfica por defecto del sistema
        fontWeight = FontWeight.Normal,          // Peso de la fuente normal
        fontSize = 16.sp,                         // Tamaño de fuente de 16sp
        lineHeight = 24.sp,                       // Altura de línea de 24sp
        letterSpacing = 0.5.sp                    // Espaciado entre letras de 0.5sp
    )
)
