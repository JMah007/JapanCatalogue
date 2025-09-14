package com.example.travelcatalogue

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var vm: CatalogueViewModel
    private var currentAllItems: List<CatalogueItem> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = (application as MyApplication).catalogueViewModel


        val favouritesListBtn = findViewById<ImageButton>(R.id.FavouritesListBtn)
        val searchBtn = findViewById<ImageButton>(R.id.SearchBtn)
        val hotelsBtn = findViewById<Button>(R.id.btnHotels)
        val foodBtn = findViewById<Button>(R.id.btnFood)
        val attractionsBtn = findViewById<Button>(R.id.btnAttractions)

        vm.hotels.observe(this) { updateCombinedItems() }
        vm.food.observe(this) { updateCombinedItems() }
        vm.attractions.observe(this) { updateCombinedItems() }

        /*
        * This method helps to initialise a new fragment with a new category list
         */
        fun replaceFragment(category: String) {
            val fragment = ItemListFragment()
            val bundle = Bundle()
            bundle.putString("category", category)
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        //Beginning of the program sets Hotels as the default list to show
        if (savedInstanceState == null){
            val fragment = ItemListFragment()
            val bundle = Bundle()
            bundle.putString("category", "Hotels")
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        hotelsBtn.setOnClickListener {
            replaceFragment("Hotels")

        }
        foodBtn.setOnClickListener {
            replaceFragment("Food")

        }
        attractionsBtn.setOnClickListener {
            replaceFragment("Attractions")

        }

        favouritesListBtn.setOnClickListener {
            val favourites = Intent(this, FavouritesActivity::class.java)
            startActivity(favourites)
        }

        searchBtn.setOnClickListener{
            val intentSearch = Intent(this, SearchActivity::class.java)
            startActivity(intentSearch)
        }
    }

    private fun updateCombinedItems(): List<CatalogueItem> {
        val hotels = vm.hotels.value.orEmpty()
        val food = vm.food.value.orEmpty()
        val attractions = vm.attractions.value.orEmpty()
        currentAllItems = hotels + food + attractions
        return currentAllItems
    }
}

