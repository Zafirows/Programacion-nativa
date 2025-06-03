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
package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Proporciona acceso a las operaciones de lectura/escritura sobre la tabla schedule.
 * Es utilizado por los ViewModels para formatear los resultados de las consultas y
 * usarlos en la interfaz de usuario.
 */
@Dao // Define que esta interfaz es un DAO (Data Access Object) utilizado por Room
interface BusScheduleDao {

    // Consulta para obtener todos los registros de la tabla 'schedule', ordenados por la hora de llegada
    @Query(
        """
        SELECT * FROM schedule 
        ORDER BY arrival_time ASC    
        """
    )
    // La consulta devuelve un Flow que emitirá una lista de objetos BusSchedule
    // Esta lista se actualiza de manera reactiva cada vez que los datos cambian en la base de datos.
    fun getAll(): Flow<List<BusSchedule>>

    // Consulta para obtener los registros de la tabla 'schedule' filtrados por el nombre de la parada (stop_name),
    // ordenados por la hora de llegada.
    @Query(
        """
        SELECT * FROM schedule 
        WHERE stop_name = :stopName 
        ORDER BY arrival_time ASC 
        """
    )
    // Al igual que la consulta anterior, esta también devuelve un Flow de una lista de objetos BusSchedule,
    // pero solo aquellos que coinciden con el nombre de la parada.
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}
