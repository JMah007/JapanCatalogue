package com.example.travelcatalogue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogue)

        val category = intent.getStringExtra("CATEGORY") ?: "Unknown"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerItems)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample items for each category
        val items = when(category) {
            "Hotels" -> listOf(
                CatalogueItems()

            "Food" -> listOf(
                CatalogueItems()
            )
            "Attractions" -> listOf(
                CatalogueItems()
            )
            else -> emptyList()
        }

        recyclerView.adapter = CatalogueAdapter(items)
    }
}
