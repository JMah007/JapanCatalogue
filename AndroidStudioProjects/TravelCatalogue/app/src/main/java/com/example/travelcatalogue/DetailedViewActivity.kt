package com.example.travelcatalogue

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)


        addFavBtn.setOnClickListener{
            // Add implementation for adding to the list of favourite catalogues.
            // for now just show a popup text
            Toast.makeText(this, "Added to favourites!", Toast.LENGTH_SHORT).show()

        }

        backBtn.setOnClickListener{
            // Add implementation for going back to previous activity whether its main page or favourites
            Toast.makeText(this, "Successfully went back!", Toast.LENGTH_SHORT).show()
        }
    }
}