package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemListFragment : Fragment(R.layout.item_list_fragment) {

    private val vm: CatalogueViewModel by activityViewModels()
    private lateinit var adapter: CatalogueAdapter

    //var category: String? = null // temporarily not using as hotels is hardcoded as the displayed list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerItemsHome)
        adapter = CatalogueAdapter(requireContext())

        // Temporarily disabled function to select a item in the recycler list on main page
//        adapter = CatalogueAdapter(requireContext()) { item ->
//            val intent = Intent(requireContext(), DetailedViewActivity::class.java).apply {
//                putExtra("title", item.title)
//                putExtra("location", item.location)
//                putExtra("description", item.description)
//                putExtra("imageResId", item.imageResId)
//                putExtra("isFavourite", false)
//            }
//            startActivity(intent)
//        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Temporarily disabled as hotels is the hardcoded list
//        when (category) {
//            "Hotels" -> vm.hotels.observe(viewLifecycleOwner) {adapter.updateItems(it) }
//            "Food" -> vm.food.observe(viewLifecycleOwner) {adapter.updateItems(it) }
//            "Attractions" -> vm.attractions.observe(viewLifecycleOwner) {adapter.updateItems(it) }
//        }


        //experimenting showing hotels only for now by hardcoding it
        /*
        * This method observes if changes are made to hotels list in ViewModel. If so then it automatically updates the new list to be displayed
         */
        vm.hotels.observe(viewLifecycleOwner) { items ->
            adapter.updateItems(items)
        }
    }
}

