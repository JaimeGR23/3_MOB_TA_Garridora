package com.example.jsonapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jsonapp.hero.Hero
import com.example.jsonapp.hero.HeroSelectionListener
import com.example.jsonapp.hero.HeroesFragment

// Main activity implementing hero selection listener
class MyMainActivityFinal : AppCompatActivity(), HeroSelectionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_main_final)
    }



    override fun onHeroSelected(hero: Hero) {
        // Save Planet - SharedPreferences
        val sharedPreferences = getSharedPreferences("MyHeroSharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("hero_key", hero.nombre)
        editor.apply()

        // Toast
        Toast.makeText(this, "Selected: ${hero.nombre}", Toast.LENGTH_SHORT).show()

        // Intent
        val intent = Intent(this, HeroDetailActivity::class.java).apply {
            putExtra("HERO_NAME", hero.nombre)
            putExtra("HERO_ORIGEN", hero.origen_mitologico)
            putExtra("HERO_DESCRIPCION", hero.descripcion)
            putExtra("HERO_PODER_UNO", hero.poder_1)
            putExtra("HERO_PODER_DOS", hero.poder_2)
            putExtra("HERO_EFECTOS_ESPECIALES", hero.efectos_especiales)
        }
        this.startActivity(intent)
    }
}
