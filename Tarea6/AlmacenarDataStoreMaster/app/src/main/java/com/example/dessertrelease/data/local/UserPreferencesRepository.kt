package com.example.dessertrelease.data.local

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * Repositorio para manejar las preferencias de usuario usando DataStore.
 *
 * @param dataStore Instancia de DataStore para almacenar preferencias
 */
class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>  // Inyecta DataStore como dependencia
) {
    // Objeto compañero para constantes
    private companion object {
        // Clave para almacenar el tipo de layout (booleano)
        val IS_LINEAR_LAYOUT = booleanPreferencesKey("is_linear_layout")
        // Tag para logging
        const val TAG = "UserPreferencesRepo"
    }

    /**
     * Flow que emite el estado actual del layout.
     *
     * - Valor true: Layout lineal
     * - Valor false: Layout grid
     * - Por defecto true (layout lineal)
     */
    val isLinearLayout: Flow<Boolean> = dataStore.data
        // Maneja errores al leer las preferencias
        .catch { exception ->
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences.", exception)
                // Emite preferencias vacías si hay error
                emit(emptyPreferences())
            } else {
                // Relanza otras excepciones
                throw exception
            }
        }
        // Mapea las preferencias al valor booleano
        .map { preferences ->
            // Obtiene el valor o usa true como valor por defecto
            preferences[IS_LINEAR_LAYOUT] ?: true
        }

    /**
     * Guarda la preferencia de layout en DataStore.
     *
     * @param isLinearLayout true para layout lineal, false para grid
     */
    suspend fun saveLayoutPreference(isLinearLayout: Boolean) {
        dataStore.edit { preferences ->
            // Actualiza el valor en las preferencias
            preferences[IS_LINEAR_LAYOUT] = isLinearLayout
        }
    }
}