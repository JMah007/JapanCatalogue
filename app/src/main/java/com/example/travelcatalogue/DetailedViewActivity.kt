package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.travelcatalogue.R

class DetailedViewActivity : AppCompatActivity() {
    private lateinit var viewModel: CatalogueViewModel
    private lateinit var currentItem: CatalogueItem
    private var isFavourite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        viewModel = (application as MyApplication).catalogueViewModel

        // This segment retrieves the items content so it can be displayed and copied
        val title = intent.getStringExtra("title") ?: "No Title"
        val location = intent.getStringExtra("location") ?: "No Location"
        val description = intent.getStringExtra("description") ?: "No Description"
        val type = intent.getStringExtra("type") ?: "No Type"
        val imageResId = intent.getIntExtra("imageResId", R.drawable.home_image)
        isFavourite = (viewModel.hotels.value
            ?.find { it.title == title }
            ?: viewModel.food.value?.find { it.title == title }
            ?: viewModel.attractions.value?.find { it.title == title }
                )?.isFavourite ?: false


        // Initialises content to be displayed
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
        updateFavBtn(favBtn)


        backBtn.setOnClickListener {
            finish()
        }

        favBtn.setOnClickListener {
            currentItem = CatalogueItem(title, location, description, type, imageResId, isFavourite)
            isFavourite = !isFavourite
            currentItem = currentItem.copy(isFavourite = isFavourite)
            viewModel.toggleFavorite(currentItem)
            updateFavBtn(favBtn)

            val message = if (isFavourite) "Added to favourites" else "Removed from favourites"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    /*
    * This handles changing the appearance of the favourites button when interacted with
     */
    private fun updateFavBtn(favBtn: ImageButton?) {
        favBtn?.setImageResource(
            if (isFavourite) R.drawable.filled_star else R.drawable.unfilled_star
        )
    }
}
