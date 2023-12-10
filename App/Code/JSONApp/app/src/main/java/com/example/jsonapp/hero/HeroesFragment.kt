package com.example.jsonapp.hero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonapp.R

// Fragment class for displaying list of heroes
class HeroesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: HeroViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_heroes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HeroViewModel::class.java]
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.heroes.observe(viewLifecycleOwner) { heroes ->
            recyclerView.adapter = HeroAdapter(heroes, activity as HeroSelectionListener)
        }
        viewModel.loadHeroes()
    }
}