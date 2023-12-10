package com.example.jsonapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jsonapp.hero.Hero
import com.example.jsonapp.hero.HeroSelectionListener

// Main activity implementing hero selection listener
class MyMainActivityFinal : AppCompatActivity(), HeroSelectionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_main_final)
        if (savedInstanceState == null) {
            // Fragment transaction to display HeroesFragment
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, HeroesFragment())
//                .commit()
        }
    }

    override fun onHeroSelected(hero: Hero) {
        // Save Planet - SharedPreferences
        val sharedPreferences = getSharedPreferences("MyHeroSharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("hero_key", hero.planet)
        editor.apply()

        // Toast
        Toast.makeText(this, "Selected: ${hero.name}", Toast.LENGTH_SHORT).show()

        // Intent
        val intent = Intent(this, HeroDetailActivity::class.java).apply {
            putExtra("HERO_NAME", hero.name)
            putExtra("HERO_MOVE", hero.specialMove)
        }
        this.startActivity(intent)
    }
}
