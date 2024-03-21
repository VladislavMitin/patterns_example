package ru.vladislavmitin.domain.repository

import ru.vladislavmitin.domain.model.DomainAttraction

interface AttractionsRepository {
    suspend fun getAttractionsByCity(cityId: Int): List<DomainAttraction>
    suspend fun getAttractions(): List<DomainAttraction>
}