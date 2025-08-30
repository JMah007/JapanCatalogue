package com.example.travelcatalogue

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FavouritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favourites)

        val recyclerItemsFavourites = view.findViewById(R.id.recyclerItemsFavourites)

        // Connect data on this line using adapter
        recyclerItemsFavourites.layoutManager = LinearLayoutManager(this) // This just changes the way items are displayed


        backBtn.setOnClickListener{
            // Add implementation for going back to previous activity whether its main page or favourites
            Toast.makeText(this, "Successfully went back!", Toast.LENGTH_SHORT).show()
        }

        }


    }
}