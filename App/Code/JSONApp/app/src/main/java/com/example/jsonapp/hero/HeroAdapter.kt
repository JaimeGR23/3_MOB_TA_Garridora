package com.example.jsonapp.hero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jsonapp.hero.HeroSelectionListener
import com.example.jsonapp.R

// Adapter class for RecyclerView to display heroes
class HeroAdapter(private val heroes: List<Hero>, private val listener: HeroSelectionListener) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    class HeroViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(hero: Hero, listener: HeroSelectionListener) {
            // Set the hero's name to the TextView
            view.findViewById<TextView>(R.id.heroName).text = hero.nombre

            // Get the ImageView reference
            val imageView = view.findViewById<ImageView>(R.id.heroImage)

            // Check if the imageURL is empty or null
            if (hero.imageURL.isEmpty()) {
                // Load a local drawable image when imageURL is empty or null
                imageView.setImageResource(R.drawable.dball)
            } else {
                // Load the image from the URL using Glide
                Glide.with(view.context)
                    .load(hero.imageURL)
                    .error(R.drawable.dball) // Fallback to a local image in case of an error
                    .into(imageView)
            }

            // Set an onClickListener to handle hero selection
            view.setOnClickListener { listener.onHeroSelected(hero) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(inflater.inflate(R.layout.item_hero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroes[position], listener)
    }

    override fun getItemCount() = heroes.size
}