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


        val allItems = intent.getSerializableExtra("allItems") as? ArrayList<CatalogueItem> ?: arrayListOf()

        val searchView = findViewById<SearchView>(R.id.searchBar)
        val filterFoodOption = findViewById<Chip>(R.id.chipFood)
        val filterHotelsOption = findViewById<Chip>(R.id.chipHotels)
        val filterAttractionsOption = findViewById<Chip>(R.id.chipAttractions)

        // 1. Variable to store current search text
        var currentSearchText: String = ""



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerItemsSearch)

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
                // Check search text
                val matchesSearch = currentSearchText.isEmpty() ||
                        item.title.contains(currentSearchText, ignoreCase = true)

                // Check chip states: pass if any selected chip matches OR no chip selected
                val chipSelected = filterFoodOption.isChecked || filterHotelsOption.isChecked || filterAttractionsOption.isChecked

                val matchesChip = (!chipSelected) ||
                        (filterFoodOption.isChecked && item.type.contains("Food", ignoreCase = true)) ||
                        (filterHotelsOption.isChecked && item.type.contains("Hotels", ignoreCase = true)) ||
                        (filterAttractionsOption.isChecked && item.type.contains("Attractions", ignoreCase = true))

                // Return true if search and chip filter both pass
                matchesSearch && matchesChip
            }

            adapter.updateItems(filteredList)
        }



// 3. SearchView listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                currentSearchText = newText
                applyFilters()  // update the list
                return true
            }
        })

// 4. Chip listener
        filterFoodOption.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Food selected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Food deselected", Toast.LENGTH_SHORT).show()
            }

            applyFilters()

        }

        filterHotelsOption.setOnCheckedChangeListener { chip, isChecked ->
            applyFilters()  // update the list whenever chip is ticked/unticked
        }

        filterAttractionsOption.setOnCheckedChangeListener { chip, isChecked ->
            applyFilters()  // update the list whenever chip is ticked/unticked
        }




//        val backBtn = findViewById<ImageButton>(R.id.backBtn)
//
//        backBtn.setOnClickListener {
//            finish()
//        }

        adapter.updateItems(allItems)
    }



}