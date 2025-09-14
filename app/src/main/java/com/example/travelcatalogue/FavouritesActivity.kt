package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavouritesActivity : AppCompatActivity() {
    private lateinit var vm: CatalogueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favourites)

        vm = (application as MyApplication).catalogueViewModel


        // Initialises content to be displayed
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerItemsFavourites)
        val backBtn = findViewById<ImageButton>(R.id.backBtn)

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


        backBtn.setOnClickListener {
            finish()
        }

        fun updateFavouritesList() {
            val allItems = (vm.hotels.value ?: emptyList()) +
                    (vm.food.value ?: emptyList()) +
                    (vm.attractions.value ?: emptyList())
            val favourites = allItems.filter {it.isFavourite}
            adapter.updateItems(favourites)
        }


        // Observes if any items are deleted or added to the favourites list
        vm.hotels.observe(this) { updateFavouritesList() }
        vm.food.observe(this) { updateFavouritesList() }
        vm.attractions.observe(this) { updateFavouritesList() }
    }
}