package com.example.travelcatalogue

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.travelcatalogue.ItemListFragment
import com.example.travelcatalogue.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnHotels).setOnClickListener { replaceFragment("Hotels") }
        findViewById<Button>(R.id.btnFood).setOnClickListener { replaceFragment("Food") }
        findViewById<Button>(R.id.btnAttractions).setOnClickListener { replaceFragment("Attractions") }
    }

    private fun replaceFragment(category: String) {
        val fragment = ItemListFragment()
        fragment.category = category

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}

