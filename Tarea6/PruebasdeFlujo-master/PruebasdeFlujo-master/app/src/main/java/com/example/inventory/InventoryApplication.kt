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

package com.example.inventory

import android.app.Application
import com.example.inventory.data.AppContainer
import com.example.inventory.data.AppDataContainer

// Clase que extiende de Application y se usa para inicializar componentes globales
class InventoryApplication : Application() {

    /**
     * Instancia de AppContainer que será usada por el resto de las clases
     * para acceder a las dependencias (repositorios, fuentes de datos, etc.).
     */
    lateinit var container: AppContainer // Se declara como lateinit porque se inicializa en onCreate

    // Se llama cuando la aplicación se inicia por primera vez
    override fun onCreate() {
        super.onCreate() // Llama a la implementación base
        container = AppDataContainer(this) // Inicializa el contenedor con el contexto de la aplicación
    }
}