package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.travelcatalogue.R

class DetailedViewActivity : AppCompatActivity() {

    private var isFavourite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        val title = intent.getStringExtra("title") ?: "No Title"
        val location = intent.getStringExtra("location") ?: "No Location"
        val description = intent.getStringExtra("description") ?: "No Description"
        val type = intent.getStringExtra("type") ?: "No Type"
        val imageResId = intent.getIntExtra("imageResId", R.drawable.home_image)
        isFavourite = intent.getBooleanExtra("isFavourite", false)

        val titleView = findViewById<TextView>(R.id.title)
        val locationView = findViewById<TextView>(R.id.location)
        val descriptionView = findViewById<TextView>(R.id.description)
        val backgroundImage = findViewById<ImageView>(R.id.backgroundImage)
        val favBtn = findViewById<ImageButton>(R.id.favBtn)
        val backBtn = findViewById<ImageButton>(R.id.backBtn)

        titleView.text = title
        locationView.text = location
        descriptionView.text = description
        backgroundImage.setImageResource(imageResId)
        favBtn.setImageResource(
            if (isFavourite) R.drawable.filled_star else R.drawable.unfilled_star
        )

        backBtn.setOnClickListener {
            finish()
        }

        favBtn.setOnClickListener {
            if (isFavourite){
                isFavourite = false
                favBtn.setImageResource(
                    R.drawable.unfilled_star
                )
                Toast.makeText(this, "Removed from favourites", Toast.LENGTH_SHORT).show()

            }
            else{
                isFavourite = true
                Toast.makeText(this, "Added to favourites", Toast.LENGTH_SHORT).show()
                favBtn.setImageResource(
                    R.drawable.filled_star
                )
            }
        }


    }
}
