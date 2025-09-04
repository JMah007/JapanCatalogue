package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val favouritesListBtn = findViewById<ImageButton>(R.id.FavouritesListBtn)
        val searchBtn = findViewById<ImageButton>(R.id.SearchBtn)
        val hotelsBtn = findViewById<Button>(R.id.btnHotels)
        val foodBtn = findViewById<Button>(R.id.btnFood)
        val attractionsBtn = findViewById<Button>(R.id.btnAttractions)


//        fun replaceFragment(category: String) {
//            val fragment = ItemListFragment()
//            fragment.category = category
//
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainer, fragment)
//                .commit()
//        }


        // Show hotels only to make sure adapter and view and binding works in general
        if (savedInstanceState == null){
            /* Line below using "apply" is from chatgpt and seems to prevent the startup screen from crashing.
            * This replaces the original assignment of fragment.category = "Hotels"
             */
//            val fragment = ItemListFragment().apply {
//                arguments = bundleOf("category" to "Hotels")
//            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ItemListFragment()) // temporarily removed passing category as string into ItemListFragmnet as its hardcoded as hotels for now
                .commit()
        }

        // Interaction with the category buttons
        hotelsBtn.setOnClickListener {
            //replaceFragment("Hotels")
            Toast.makeText(this, "Displaying Hotels", Toast.LENGTH_SHORT).show()
        }
        foodBtn.setOnClickListener {
            //replaceFragment("Food")
            Toast.makeText(this, "Displaying Food", Toast.LENGTH_SHORT).show()
        }
        attractionsBtn.setOnClickListener {
            //replaceFragment("Attractions")
            Toast.makeText(this, "Displaying Attractions", Toast.LENGTH_SHORT).show()
        }

        favouritesListBtn.setOnClickListener{
            val intentFavourites = Intent(this, FavouritesActivity::class.java)
            startActivity(intentFavourites)
        }

        searchBtn.setOnClickListener{
            // implement search stuff here
            Toast.makeText(this, "Search bar appears", Toast.LENGTH_SHORT).show()
        }
    }

}

