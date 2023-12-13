package com.example.jsonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class HeroDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_hero_detail)

        val heroName = intent.getStringExtra("HERO_NAME")
        val heroOrigen = intent.getStringExtra("HERO_ORIGEN")
        val heroDescripcion = intent.getStringExtra("HERO_DESCRIPCION")
        val heroPoderUno = intent.getStringExtra("HERO_PODER_UNO")
        val heroPoderDos = intent.getStringExtra("HERO_PODER_DOS")
        val heroEfectosEspeciales = intent.getStringExtra("HERO_EFECTOS_ESPECIALES")

        // Get SharedPreferences Data
        val sharedPreferences = getSharedPreferences("MyHeroSharedPref", MODE_PRIVATE)
        val heroPlanet = sharedPreferences.getString("hero_key", "DefaultHeroPlanet")

        Log.d("HeroPlanet", "Hero planet from SharedPreferences: $heroPlanet")

        this.title = heroName
        findViewById<TextView>(R.id.origen_mitologico).text = "Origen: " + heroOrigen
        findViewById<TextView>(R.id.descripcion).text = heroDescripcion
        findViewById<TextView>(R.id.poder_1).text = heroPoderUno
        findViewById<TextView>(R.id.poder_2).text = heroPoderDos
        findViewById<TextView>(R.id.efectos_especiales).text = heroEfectosEspeciales
    }
}
