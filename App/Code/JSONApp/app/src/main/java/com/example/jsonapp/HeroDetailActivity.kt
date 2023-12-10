package com.example.jsonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.jsonapp.hero.Hero

class HeroDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_hero_detail)

        val heroName = intent.getStringExtra("HERO_NAME")
        val heroMove = intent.getStringExtra("HERO_MOVE")

        // Get SharedPreferences Data
        val sharedPreferences = getSharedPreferences("MyHeroSharedPref", MODE_PRIVATE)
        val heroPlanet = sharedPreferences.getString("hero_key", "DefaultHeroPlanet")

        Log.d("HeroPlanet", "Hero planet from SharedPreferences: $heroPlanet")

        this.title = heroName
        findViewById<TextView>(R.id.heroDetailName).text = heroMove
    }
}
