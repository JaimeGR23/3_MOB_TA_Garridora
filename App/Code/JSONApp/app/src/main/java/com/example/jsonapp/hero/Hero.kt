package com.example.jsonapp.hero

// Data class representing a hero with additional imageURL property
data class Hero(
    val name: String,
    val race: String,
    val specialMove: String,
    val planet: String,
    val alignment: String,
    val imageURL: String
)