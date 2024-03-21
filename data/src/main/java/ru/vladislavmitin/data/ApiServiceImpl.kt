package ru.vladislavmitin.data

import kotlinx.coroutines.delay
import ru.vladislavmitin.data.dto.ApiAttraction
import ru.vladislavmitin.data.dto.ApiCity

class ApiServiceImpl: ApiService {

    override suspend fun getCities(): List<ApiCity> {
        delay(1_000)
        return CITIES
    }

    override suspend fun getAttractionsByCity(cityId: Int): List<ApiAttraction> {
        delay(1_000)
        return ATTRACTIONS.filter { it.cityId == cityId }
    }

    override suspend fun getAttractions(): List<ApiAttraction> {
        delay(1_000)
        return ATTRACTIONS
    }

    private companion object {
        val CITIES: List<ApiCity> = listOf(
            ApiCity(
                1,
                "Липецк",
                500_000,
                "https://lipetskmedia.ru/image/images(1).jpg",
            ),
            ApiCity(
                2,
                "Москва",
                13_000_000,
                "https://cdn.inari.pro/watermarkcache/ef/75/ef75b4a2199749aeabb6fbdbfd59ae1f.png",
            ),
            ApiCity(
                3,
                "Санкт-Петербург",
                5_500_000,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Coat_of_Arms_of_Saint_Petersburg_%282003%29.svg/1200px-Coat_of_Arms_of_Saint_Petersburg_%282003%29.svg.png",
            ),
        )

        val ATTRACTIONS: List<ApiAttraction> = listOf(
            ApiAttraction(
                1,
                2,
                "Красная площадь",
                "Красная площадь, Москва 109012 Россия\n" +
                        "Район/квартал: Садовое кольцо\n" +
                        "Как сюда добраться\n" +
                        "Площадь Революции • 4 мин пешком\n" +
                        "Курская • 4 мин пешком",
                "4.5",
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/13/da/f2/3e/roter-platz.jpg?w=1200&h=-1&s=1",
            ),

        )
    }
}