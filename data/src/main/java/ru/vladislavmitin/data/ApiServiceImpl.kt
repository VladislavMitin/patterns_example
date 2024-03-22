package ru.vladislavmitin.data

import kotlinx.coroutines.delay
import ru.vladislavmitin.data.dto.ApiAttraction
import ru.vladislavmitin.data.dto.ApiCity

class ApiServiceImpl : ApiService {

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
                "https://www.pnp.ru/upload/entities/2021/09/24/15/article/detailPicture/55/cd/86/a8/a94b72b5444bb7ed0189aeca9975fc76.jpg",
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
                "https://moskultura.ru/wp-content/uploads/2022/08/krasn_pl1-1140x668.jpg",
            ),
            ApiAttraction(
                2,
                1,
                "Христо-Рождественский кафедральный собор",
                "У главного храма Липецка очень сложная судьба. В процессе его строительства, в начале 19-го века, произошёл серьёзный пожар. Собор начали восстанавливать, дело шло медленно, поэтому освящение происходило поэтапно, частями. Все три престола были освящены к 1816-му году. А потом начали строить колокольню.",
                "5.0",
                "https://vesti-lipetsk.ru/files/%D1%81%D1%82%D0%B0%D1%82%D1%8C%D0%B8/%D1%81%D0%BE%D0%B1%D0%BE%D1%80/2893813.jpg",
            ),
            ApiAttraction(
                3,
                3,
                "Большой Петергофский дворец",
                "1 этап постройки: 1715-1725 гг.\n" +
                        "Архитекторы И.Ф. Браунштейн, Ж.-Б. Леблон, Н. Микетти.\n" +
                        "2 этап постройки: 1745-1755 гг. Архитектор Ф.Б. Растрелли.",
                "4.6",
                "https://musicvoyages.ru/wp-content/uploads/2022/01/photogenica-phx277933836umen-768x512.jpg",
            ),
        )
    }
}
