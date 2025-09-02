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

    private lateinit var adapter: CatalogueAdapter
    private val vm: CatalogueViewModel by activityViewModels()

    var category: String? = null
    private var allItems: List<CatalogueItem> = emptyList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerItemsHome)
        adapter = CatalogueAdapter(requireContext(), { item ->
            val intent = Intent(requireContext(), DetailedViewActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("location", item.location)
                putExtra("description", item.description)
                putExtra("imageResId", item.imageResId)
                putExtra("isFavourite", false)
            }
            startActivity(intent)
        }, emptyList())

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val filterSpinner = view.findViewById<Spinner>(R.id.spinnerFilter)
        val type = listOf("All", "Luxury", "Budget", "Family") // you can adjust
        filterSpinner.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, type).apply {
                setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }

        filterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedType = type[position]
                applyFilter(selectedType)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        when (category) {
            "Hotels" -> vm.hotels.observe(viewLifecycleOwner) {
                allItems = it
                applyFilter(filterSpinner.selectedItem.toString())
            }

            "Food" -> vm.food.observe(viewLifecycleOwner) {
                allItems = it
                applyFilter(filterSpinner.selectedItem.toString())
            }

            "Attractions" -> vm.attractions.observe(viewLifecycleOwner) {
                allItems = it
                applyFilter(filterSpinner.selectedItem.toString())
            }
        }
    }

    private fun applyFilter(type: String) {
        val filtered = if (type == "All") {
            allItems
        } else {
            allItems.filter { it.type == type }
        }
        adapter.updateItems(filtered)
    }
}

