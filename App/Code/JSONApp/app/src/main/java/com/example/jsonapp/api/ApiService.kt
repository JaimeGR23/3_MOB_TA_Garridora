package com.example.jsonapp.api

import com.example.jsonapp.hero.Hero
import retrofit2.http.GET

// Retrofit interface for fetching heroes data
interface ApiService {
    @GET("objetos")
    suspend fun getHeroes(): List<Hero>
}