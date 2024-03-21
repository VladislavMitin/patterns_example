package ru.vladislavmitin.domain.usecase

import ru.vladislavmitin.domain.model.DomainAttraction
import ru.vladislavmitin.domain.model.DomainCity

interface GetCitiesWithAttractionsUseCase {
    suspend fun getCitiesWithAttractions(): Map<DomainCity, List<DomainAttraction>>
}