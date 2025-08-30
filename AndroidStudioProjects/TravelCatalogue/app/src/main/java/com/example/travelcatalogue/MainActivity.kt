package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHotels = findViewById<Button>(R.id.btnHotels)
        val btnFood = findViewById<Button>(R.id.btnFood)
        val btnAttractions = findViewById<Button>(R.id.btnAttractions)

        btnHotels.setOnClickListener {
            val intent = Intent(this, CatalogueActivity::class.java)
            intent.putExtra("CATEGORY", "Hotels")
            startActivity(intent)
        }

        btnFood.setOnClickListener {
            val intent = Intent(this, CatalogueActivity::class.java)
            intent.putExtra("CATEGORY", "Food")
            startActivity(intent)
        }

        btnAttractions.setOnClickListener {
            val intent = Intent(this, CatalogueActivity::class.java)
            intent.putExtra("CATEGORY", "Attractions")
            startActivity(intent)
        }
    }
}
