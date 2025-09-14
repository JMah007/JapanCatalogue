package com.example.travelcatalogue

data class CatalogueItem(
    val title: String,
    val location: String,
    val description: String,
    val type: String,
    val imageResId: Int = R.drawable.home_image,
    var isFavourite: Boolean = false
)
