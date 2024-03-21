package ru.vladislavmitin.data.repository

import ru.vladislavmitin.data.ApiService
import ru.vladislavmitin.data.dto.toDomain
import ru.vladislavmitin.domain.model.DomainAttraction
import ru.vladislavmitin.domain.repository.AttractionsRepository

class AttractionsRepositoryImpl(
    private val service: ApiService
): AttractionsRepository {
    override suspend fun getAttractionsByCity(cityId: Int): List<DomainAttraction> {
        return service.getAttractionsByCity(cityId).map { it.toDomain() }
    }

    override suspend fun getAttractions(): List<DomainAttraction> {
        return service.getAttractions().map { it.toDomain() }
    }
}