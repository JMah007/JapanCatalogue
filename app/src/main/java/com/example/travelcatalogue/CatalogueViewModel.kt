package com.example.travelcatalogue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatalogueViewModel : ViewModel() {

    private val _hotels = MutableLiveData<List<CatalogueItem>>(
        listOf(
            CatalogueItem("Niseko Ski Resort", "Hokkaido", "The most famous ski resort in all of Japan, known for having tons of light powder snow and is especially famous amongst Australians, who in recent decades have popularize the resort for skiing and snowboarding purposes.", "Hotel", R.drawable.niseko, true),
            CatalogueItem("Four Seasons Marunouchi", "Tokyo", "Located in the heart of Tokyo, this hotel provides the highest level of service and comfortability to all its customer. Experience all kinds of luxury from relaxing high tea to drinking in a classy night bar to enjoying French cuisine in a 3-michelin star restaurant.", "Hotel", R.drawable.fourseasons, false),
            CatalogueItem("W Osaka", "Osaka", "Nestled in the fun-filled heart of Shinsaibashi, W Osaka blends Japan’s celebrated cultural heritage with bold contemporary designs in a rarified milieu of playful chic and boundless luxury . Reboot all your social needs at the electric nightlife scenery of Dotonbori just around the corner.", "Hotel", R.drawable.w, false),
            CatalogueItem("Hakone Ashinoko Hanaori", "Kanagawa", "Featuring a terrace with views of Lake Ashi of Hakone, Ashinoko Hanaori offers a soothing hot spring bath and sauna. The property is situated  a 2-minute walk from Togendai Station on Hakone Ropeway.", "Hotel", R.drawable.hakone, false),
            CatalogueItem("Umino Ryotei Okinawa Nakamasou", "Okinawa", "This place offers family rooms with sea views, each room includes air-conditioning, a balcony, private bathroom, and modern amenities. It also allows all customers to enjoy a relaxing time in sauna, garden and the nearby beach.", "Hotel", R.drawable.umino, false),
            CatalogueItem("Ryokan Kanade", "Kyoto", "Conveniently located in central Kyoto, Ryokan KANADE offers a Japanese-style garden. Its rooms are complete with a private bathroom fitted with a bath and they provide the traditional Japanese bath robes, Yukata for whoever pleases to visit the private open-air bath on the rooftop.", "Hotel", R.drawable.kanade, false),
            CatalogueItem("Kominka Neri", "Fukuoka", "This hotel offers traditional Japanese tatami rooms to allow customers to fully experience the Japanese culture in their accomodation. Around the property has several tourist spots such as museum, park and a shrine.", "Hotel", R.drawable.kominka, false),
            CatalogueItem("Arima Grand Hotel", "Kobe", "Boasting an open-air hot springs bath and spacious garden, Arima Grand Hotel is located a 10-minute walk away from Arima Onsen Station. This hotel is also equipped with a seasonal outdoor pool, various spa and wellness facilities and also private use hot spring bath.", "Hotel", R.drawable.arima, false),
            CatalogueItem("Yuyaruru Saisai", "Kanazawa", "Offering views of the Sai River, Yuyaruru Saisai’s spacious Japanese-style rooms offers every customers the best possible experience through every night and also a private bath for customers to experience a relaxing time of their life. Tatami floors and Japanese futon bedding are included in all rooms.", "Hotel", R.drawable.saisai, false),
            CatalogueItem("Hotel Futaba", "Niigata", "Surrounded by the natural beauty of the Mount Tanigawa, Hotel Futaba lies on the high plains of the historical Echigo-Yuzawa Onsen hot spring area. It offers comfortable Japanese tatami rooms with private bathing facilities, as well as indoor and outdoor baths with splendid mountain views.", "Hotel", R.drawable.futaba, false)
        )
    )
    private val _food = MutableLiveData<List<CatalogueItem>>(
        listOf(
            CatalogueItem("Omoide Yokocho", "Tokyo", "Also known as Memory Lane, Omoide Yokocho is a historic alley in Shinjuku, Tokyo, famous for its traditional eateries and vibrant atmosphere, offering a taste of post-war Japan.", "Food", R.drawable.omoide, false),
            CatalogueItem("Yokohama Chinatown", "Kanagawa", "It is the largest chinatown in Japan with rougly 250 chinese-owned or themed shops and restaurants scattered throughout the district, making it the perfect spot for anyone looking to enjoy delicious Japanese-Chinese food.", "Food", R.drawable.chinatown, false),
            CatalogueItem("Ichiran ramen", "All across Japan", "Originating from Fukuoka prefecture, this ramen franchise has become one of if not the most famous and influential ramen franchise not just in Japan but all across the globe.", "Food", R.drawable.ichiran, false),
            CatalogueItem("Sushiro", "All across Japan", "Sushiro is a sushi train franchise that is well-known and familiar to locals. It offers a wide range of sushi using only the freshest ingredients from the sea of Japan, making it a must-visit for sushi enthusiasts.", "Food", R.drawable.sushiro, false),
            CatalogueItem("HAJIME", "Osaka", "HAJIME is a restaurant that captures the beauty and harmony of nature, Earth, and the universe in its cuisine. It invites you to savor the world of HAJIME and explore the questions of life, love and enjoyment. They have also recently been awarded 3 michelin stars in the Michelin Guide 2025.","Food", R.drawable.hajime, false),
            CatalogueItem("Jukeihanten Yokohama Chukagai Shinkan", "Yokohama", "Located in the heart of Japan's biggest chinatown, Yokohama, this Chinese restaurant offers a wide range of mouth-watering chinese food that customers can enjoy.", "Food", R.drawable.shinkan, false),
            CatalogueItem("Okinawa Soba Eibun", "Okinawa", "This local restaurant located in the island of Okinawa offers a dish that is very familiar to the Okinawans, the Okinawa Soba. Truly a one of a kind meal that you can only get in Okinawa.", "Food", R.drawable.eibun, false),
            CatalogueItem("Kushi Katsu A-bon", "Hyogo", "They offer a dinner course featuring around 20 skewers, with two seatings each night. With meticulous attention to ingredient selection, preparation, and frying techniques, each skewer is crafted to perfection, ensuring a loyal following of repeat customers, perfect for customers who wants to experience kushikatsu.", "Food", R.drawable.kushikatsu, false),
            CatalogueItem("Sumiyaki Hitsumabushi Unagi Munagi", "Nagoya", "This restaurant provides the highest quality of Nagoya's most beloved local cuisine, Hitsumabushi, which is a unique rice bowl topped with lots of eel and eaten with tea.", "Hotel", R.drawable.hitsumabushi, false),
            CatalogueItem("Saizeriya", "All across Japan", "Saizeriya is the most famous Italian food chain in Japan. It offers cheap but high quality Italian food that anyone can easily enjoy on their own or with families and friends.", "Hotel", R.drawable.saizeriya, false)
        )
    )
    private val _attractions = MutableLiveData<List<CatalogueItem>>(
        listOf(
            CatalogueItem("Okinawa Churaumi Aquarium", "Okinawa", "One of the biggest aquarium in the world home to 780 species of marine lives.", "Attractions", R.drawable.aquarium, false),
            CatalogueItem("Mount Fuji", "Yamanashi/Shizuoka", "Japan's tallest mountain and has visible snow on its tip all year long which is an iconic spot for hikinh and artwork inspiration.", "Attractions", R.drawable.fuji, false),
            CatalogueItem("Fushimi Inari Shrine", "Kyoto", "A shrine located in the old capital of Japan that is iconic for its thousands of vibrant red Torii gates. Takes around 12,000 steps to reach the top.", "Attractions", R.drawable.inari, false),
            CatalogueItem("Shibuya", "Tokyo", "A major commercial center that houses one of the busiest railway station in the world and boasts a population density of 16 thousand people per square kilometer.", "Attractions", R.drawable.shibuya, false),
            CatalogueItem("DisneySea Tokyo", "Chiba", "The one and only DisneySea in the world is located right next to Tokyo. It is a place that needs no introduction and provides everyone who enters a once-in-a-lifetime magical experience that will definitely bring them back again.", "Attractions", R.drawable.disney, false),
            CatalogueItem("Universal Studio Japan", "Osaka", "Universal Studio Japan is a special place that allows customers to enjoy thrilling rides and games. It offers a wide range of seasonal themed-games based on the trendiest anime.", "Attractions", R.drawable.usj, false),
            CatalogueItem("Arashiyama Bamboo Forest", "Kyoto", "Explore one of Kyoto's most iconic sight, the Arashiyama Bamboo Forest is a must-do activity for whoever visiting Kyoto. Walking down the small alley way surrounded by bamboos gives the best experience on nature.", "Attractions", R.drawable.bamboo, false),
            CatalogueItem("Nara Deer Park", "Nara", "A historical park that is home to hundreds of semi-wild deer that you can feed and interact with. These deers roam around the park freely to allow unlimited interactions between the deer and the people. Crackers for the deer are sold at a cheap price in the nearby shops for everyone to better interact with the deers.", "Attractions", R.drawable.deer, false),
            CatalogueItem("Tokyo Skytree", "Tokyo", "Tokyo Skytree is the third tallest structure in the world, boasting a height of 634 metres tall. Although it started off as a normal broadcasting tower, it is now a very well-known observation deck for both locals and tourists alike. Once you reach the top of the building, you are able to have the best view of the whole of Tokyo at a glance.", "Attractions", R.drawable.skytree, false),
            CatalogueItem("Sapporo Snow Festival", "Hokkaido", "The Sapporo Snow Festival is an event that is held every February in Hokkaido's capital city, Sapporo for only a week and it is the most famous winter activity in Japan. The festival features the country's best ice and snow sculptures that is sure to capture the hearts of every person. Truly an event that you cannot miss.", "Attractions", R.drawable.snow, false)
        )
    )

    val hotels: LiveData<List<CatalogueItem>> = _hotels
    val food: LiveData<List<CatalogueItem>> = _food
    val attractions: LiveData<List<CatalogueItem>> = _attractions

}
