package com.example.travelcatalogue
import android.app.Application

class MyApplication : Application() {
    val catalogueViewModel = CatalogueViewModel(this)
}
