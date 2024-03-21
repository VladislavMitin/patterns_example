package ru.vladislavmitin.data.repository

import ru.vladislavmitin.data.ApiService
import ru.vladislavmitin.data.dto.toDomain
import ru.vladislavmitin.domain.model.DomainCity
import ru.vladislavmitin.domain.repository.CitiesRepository

class CitiesRepositoryImpl(
    private val service: ApiService
): CitiesRepository {
    override suspend fun getCities(): List<DomainCity> {
        return service.getCities().map { it.toDomain() }
    }
}