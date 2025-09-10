package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavouritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favourites)

        val allItems = intent.getSerializableExtra("allItems") as? ArrayList<CatalogueItem> ?: arrayListOf()
        val favourites = allItems.filter { it.isFavourite }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerItemsFavourites)

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

        val backBtn = findViewById<ImageButton>(R.id.backBtn)

        backBtn.setOnClickListener {
            finish()
        }

        adapter.updateItems(favourites)




    }
}