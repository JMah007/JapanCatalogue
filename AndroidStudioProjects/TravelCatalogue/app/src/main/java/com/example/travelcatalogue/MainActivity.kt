package com.example.travelcatalogue

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Sets up transition to "Favourites" page
        btnFavourites.setOnClickListener{
            val favouritesIntent = Intent(this, FavouritesActivity::class.java)

            startActivity(favouritesIntent)

        }
    }
}