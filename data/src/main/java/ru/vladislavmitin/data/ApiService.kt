package ru.vladislavmitin.data

import ru.vladislavmitin.data.dto.ApiAttraction
import ru.vladislavmitin.data.dto.ApiCity

interface ApiService {
    suspend fun getCities(): List<ApiCity>
    suspend fun getAttractionsByCity(cityId: Int): List<ApiAttraction>
    suspend fun getAttractions(): List<ApiAttraction>
}