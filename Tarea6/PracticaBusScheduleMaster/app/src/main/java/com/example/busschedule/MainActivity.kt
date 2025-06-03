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
package com.example.busschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.busschedule.ui.BusScheduleApp
import com.example.busschedule.ui.theme.BusScheduleTheme

/**
 * Actividad principal de la aplicación de horarios de autobuses.
 *
 * Esta es la entrada principal de la aplicación que configura la interfaz de usuario.
 */
class MainActivity : ComponentActivity() {

    /**
     * Método llamado cuando se crea la actividad.
     * @param savedInstanceState Estado previo guardado (si aplica)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Llama a la implementación de la clase padre
        super.onCreate(savedInstanceState)

        // 2. Configura el contenido usando Jetpack Compose
        setContent {
            // 3. Aplica el tema personalizado de la aplicación
            BusScheduleTheme {
                // 4. Muestra el composable raíz de la aplicación
                BusScheduleApp()
            }
        }
    }
}
