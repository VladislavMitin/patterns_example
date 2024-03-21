package ru.vladislavmitin.domain.repository

import ru.vladislavmitin.domain.model.DomainCity

interface CitiesRepository {
    suspend fun getCities(): List<DomainCity>
}