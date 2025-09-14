package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip;

class SearchActivity: AppCompatActivity() {
    private lateinit var vm: CatalogueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        vm = (application as MyApplication).catalogueViewModel

        // Combine all the lists into one list that can be displayed with all categories together
        val allItems = (vm.hotels.value ?: emptyList()) +
                (vm.food.value ?: emptyList()) +
                (vm.attractions.value ?: emptyList())

        // Initialises content to be displayed
        val searchQuery = findViewById<SearchView>(R.id.searchBar)
        val filterFoodOption = findViewById<Chip>(R.id.chipFood)
        val filterHotelsOption = findViewById<Chip>(R.id.chipHotels)
        val filterAttractionsOption = findViewById<Chip>(R.id.chipAttractions)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerItemsSearch)
        val backBtn = findViewById<ImageButton>(R.id.backBtn)

        var currentSearchText: String = ""


        // Handles selection of item and starts activity for detailed view
        val adapter = CatalogueAdapter{ item ->
            val intent = Intent(this, DetailedViewActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("location", item.location)
                putExtra("description", item.description)
                putExtra("imageResId", item.imageResId)
                putExtra("isFavourite", item.isFavourite)
            }
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        /*
        * This function only adds items to a list that match the search requirements
         */
        fun applyFilters() {
            val filteredList = allItems.filter { item ->
                // Match searchQuery. If its empty then passes as true as we want all items to be shown if no search query is given
                val matchesSearch = currentSearchText.isEmpty() ||
                        item.title.contains(currentSearchText, ignoreCase = true)

                // Check if chip has been selected or not and pass either way
                val chipSelected = filterFoodOption.isChecked || filterHotelsOption.isChecked || filterAttractionsOption.isChecked

                // Match according to the chip. If no chip selected then pass as we want all items to be shown if no filter is selected
                val matchesChip = (!chipSelected) ||
                        (filterFoodOption.isChecked && item.type.contains("Food", ignoreCase = true)) ||
                        (filterHotelsOption.isChecked && item.type.contains("Hotel", ignoreCase = true)) ||
                        (filterAttractionsOption.isChecked && item.type.contains("Attraction", ignoreCase = true))

                // Return true if search and chip filter both pass
                matchesSearch && matchesChip
            }
            adapter.updateItems(filteredList)
        }


        // Handles change in searchQuery typed in
        searchQuery.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // We don't implement this as we don't use submit button as we want live updates
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                currentSearchText = newText
                applyFilters()
                return true
            }
        })


        // These are for instances where theres no change to the searchQuery so handles change in checked status of filters
        filterFoodOption.setOnCheckedChangeListener { _, _ ->
            applyFilters()

        }

        // These are for instances where theres no change to the searchQuery so handles change in checked status of filters
        filterHotelsOption.setOnCheckedChangeListener { _, _ ->
            applyFilters()
        }

        // These are for instances where theres no change to the searchQuery so handles change in checked status of filters
        filterAttractionsOption.setOnCheckedChangeListener { _, _ ->
            applyFilters()
        }


        backBtn.setOnClickListener {
            finish()
        }

        adapter.updateItems(allItems)
    }
}