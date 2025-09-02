package com.example.travelcatalogue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatalogueViewModel : ViewModel() {

    private val _hotels = MutableLiveData<List<CatalogueItem>>(
        listOf(
            CatalogueItem("Niseko Ski Resort", "Hokkaido", "The most famous ski resort in all of Japan, known for having tons of light powder snow and is especially famous amongst Australians, who in recent decades have popularize the resort for skiing and snowboarding purposes.", "5-stars"),
            CatalogueItem("Four Seasons Marunouchi", "Tokyo", "Located in the heart of Tokyo, this hotel provides the highest level of service and comfortability to all its customer. Experience all kinds of luxury from relaxing high tea to drinking in a classy night bar to enjoying French cuisine in a 3-michelin star restaurant.", "5-stars")
        )
    )
    private val _food = MutableLiveData<List<CatalogueItem>>(
        listOf(
            CatalogueItem("Omoide Yokocho", "Tokyo", "Also known as Memory Lane, Omoide Yokocho is a historic alley in Shinjuku, Tokyo, famous for its traditional eateries and vibrant atmosphere, offering a taste of post-war Japan.", "Bars and snacks"),
            CatalogueItem("Yokohama Chinatown", "Kanagawa", "It is the largest chinatown in Japan with rougly 250 chinese-owned or themed shops and restaurants scattered throughout the district, making it the perfect spot for anyone looking to enjoy delicious Japanese-Chinese food.", "Food district"),
            CatalogueItem("Ichiran ramen", "All across Japan", "Originating from Fukuoka prefecture, this ramen franchise has become one of if not the most famous and influential ramen franchise not just in Japan but all across the globe.", "Ramen franchise"),
            CatalogueItem("Sushiro", "All across Japan", "Sushiro is a sushi train franchise that is well-known and familiar to locals. It offers a wide range of sushi using only the freshest ingredients from the sea of Japan, making it a must-visit for sushi enthusiasts.", "Sushi train franchise")
        )
    )
    private val _attractions = MutableLiveData<List<CatalogueItem>>(
        listOf(
            CatalogueItem("Okinawa Churaumi Aquarium", "Okinawa", "One of the biggest aquarium in the world home to 780 species of marine lives.", "Recreational centre"),
            CatalogueItem("Mount Fuji", "Yamanashi/Shizuoka", "Japan's tallest mountain and has visible snow on its tip all year long which is an iconic spot for hikinh and artwork inspiration.", "World heritage site"),
            CatalogueItem("Fushimi Inari Shrine", "Kyoto", "A shrine located in the old capital of Japan that is iconic for its thousands of vibrant red Torii gates. Takes around 12,000 steps to reach the top.", "Memorial site"),
            CatalogueItem("Shibuya", "Tokyo", "A major commercial center that houses one of the busiest railway station in the world and boasts a population density of 16 thousand people per square kilometer.", "Business district")
        )
    )

    val hotels: LiveData<List<CatalogueItem>> = _hotels
    val food: LiveData<List<CatalogueItem>> = _food
    val attractions: LiveData<List<CatalogueItem>> = _attractions
}
