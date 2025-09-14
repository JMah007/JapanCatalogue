package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemListFragment : Fragment(R.layout.item_list_fragment) {
    private val vm: CatalogueViewModel by activityViewModels()
    private lateinit var adapter: CatalogueAdapter
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = requireArguments().getString("category") ?: "Hotels" // if no category is provided then fallback to Hotels
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerItemsHome)

        adapter = CatalogueAdapter{ item ->
            val intent = Intent(requireContext(), DetailedViewActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("location", item.location)
                putExtra("description", item.description)
                putExtra("imageResId", item.imageResId)
                putExtra("isFavourite", item.isFavourite)
            }
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Selects list the user chooses to view
        when (category) {
            "Hotels" -> vm.hotels.observe(viewLifecycleOwner) {adapter.updateItems(it) }
            "Food" -> vm.food.observe(viewLifecycleOwner) {adapter.updateItems(it) }
            "Attractions" -> vm.attractions.observe(viewLifecycleOwner) {adapter.updateItems(it) }
        }
    }
}

