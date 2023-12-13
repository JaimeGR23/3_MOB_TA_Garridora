package com.example.jsonapp.hero

// Data class representing a hero with additional imageURL property
data class Hero(
    val nombre: String,
    val origen_mitologico: String,
    val descripcion: String,
    val poder_1: String,
    val poder_2: String,
    val efectos_especiales: String,
    val imageURL: String,


)