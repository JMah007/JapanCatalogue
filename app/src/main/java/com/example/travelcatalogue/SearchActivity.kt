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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        // change this once serialisable is not used as we werent taught as? function
        val allItems = intent.getSerializableExtra("allItems") as? ArrayList<CatalogueItem> ?: arrayListOf()

        val searchQuery = findViewById<SearchView>(R.id.searchBar)
        val filterFoodOption = findViewById<Chip>(R.id.chipFood)
        val filterHotelsOption = findViewById<Chip>(R.id.chipHotels)
        val filterAttractionsOption = findViewById<Chip>(R.id.chipAttractions)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerItemsSearch)
        val backBtn = findViewById<ImageButton>(R.id.backBtn)

        var currentSearchText: String = ""


        // Handles selection of item and starts activity for detailed view
        val adapter = CatalogueAdapter(this) { item ->
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
            // Don't implement this as we don't use submit button as we want live updates
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                currentSearchText = newText
                applyFilters()  // update the list
                return true
            }
        })

        // These are for if theres no search query so applyFilters need to be watched by onCheckedListeners
        filterFoodOption.setOnCheckedChangeListener { chip, isChecked ->
            applyFilters()

        }

        // These are for if theres no search query so applyFilters need to be watched by onCheckedListeners
        filterHotelsOption.setOnCheckedChangeListener { chip, isChecked ->
            applyFilters()  // update the list whenever chip is ticked/unticked
        }

        // These are for if theres no search query so applyFilters need to be watched by onCheckedListeners
        filterAttractionsOption.setOnCheckedChangeListener { chip, isChecked ->
            applyFilters()  // update the list whenever chip is ticked/unticked
        }


        backBtn.setOnClickListener {
            finish()
        }

        adapter.updateItems(allItems)
    }
}