/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licencia Apache 2.0
 */
package com.example.courses.data

import com.example.courses.R
import com.example.courses.model.Topic

// Objeto que contiene los datos de ejemplo para mostrar en la aplicación
object DataSource {
    // Lista de temas disponibles, cada uno con:
    // - una referencia a un string (nombre del tema)
    // - un número de cursos disponibles
    // - una imagen asociada
    val topics = listOf(
        Topic(R.string.architecture, 58, R.drawable.architecture), // Arquitectura
        Topic(R.string.automotive, 30, R.drawable.automotive),     // Automotriz
        Topic(R.string.biology, 90, R.drawable.biology),           // Biología
        Topic(R.string.crafts, 121, R.drawable.crafts),            // Manualidades
        Topic(R.string.business, 78, R.drawable.business),         // Negocios
        Topic(R.string.culinary, 118, R.drawable.culinary),        // Cocina
        Topic(R.string.design, 423, R.drawable.design),            // Diseño
        Topic(R.string.ecology, 28, R.drawable.ecology),           // Ecología
        Topic(R.string.engineering, 67, R.drawable.engineering),   // Ingeniería
        Topic(R.string.fashion, 92, R.drawable.fashion),           // Moda
        Topic(R.string.finance, 100, R.drawable.finance),          // Finanzas
        Topic(R.string.film, 165, R.drawable.film),                // Cine
        Topic(R.string.gaming, 37, R.drawable.gaming),             // Videojuegos
        Topic(R.string.geology, 290, R.drawable.geology),          // Geología
        Topic(R.string.drawing, 326, R.drawable.drawing),          // Dibujo
        Topic(R.string.history, 189, R.drawable.history),          // Historia
        Topic(R.string.journalism, 96, R.drawable.journalism),     // Periodismo
        Topic(R.string.law, 58, R.drawable.law),                   // Derecho
        Topic(R.string.lifestyle, 305, R.drawable.lifestyle),      // Estilo de vida
        Topic(R.string.music, 212, R.drawable.music),              // Música
        Topic(R.string.painting, 172, R.drawable.painting),        // Pintura
        Topic(R.string.photography, 321, R.drawable.photography),  // Fotografía
        Topic(R.string.physics, 41, R.drawable.physics),           // Física
        Topic(R.string.tech, 118, R.drawable.tech),                // Tecnología
    )
}
