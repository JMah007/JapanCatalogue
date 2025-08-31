package com.example.travelcatalogue

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemListFragment : Fragment(R.layout.item_catalogue) {

    private lateinit var adapter: CatalogueAdapter
    private val vm: CatalogueViewModel by activityViewModels()

    var category: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerItemsHome)
        adapter = CatalogueAdapter(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        when (category) {
            "Hotels" -> vm.hotels.observe(viewLifecycleOwner) { adapter.updateItems(it) }
            "Food" -> vm.food.observe(viewLifecycleOwner) { adapter.updateItems(it) }
            "Attractions" -> vm.attractions.observe(viewLifecycleOwner) { adapter.updateItems(it) }
        }
    }
}

