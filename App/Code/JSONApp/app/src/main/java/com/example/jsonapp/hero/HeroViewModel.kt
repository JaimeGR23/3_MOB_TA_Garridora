package com.example.jsonapp.hero

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonapp.api.RetrofitClient
import kotlinx.coroutines.launch

// ViewModel class for heroes data handling
class HeroViewModel : ViewModel() {
    private val _heroes = MutableLiveData<List<Hero>>()
    val heroes: LiveData<List<Hero>> = _heroes

    fun loadHeroes() {
        viewModelScope.launch {
            try {
                val heroesList = RetrofitClient.apiService.getHeroes()
                _heroes.value = heroesList
            } catch (e: Exception) {
                Log.d("Error", "Error loading heroes: ${e.message}")
            }
        }
    }
}