package ru.vladislavmitin.domain.usecase

import ru.vladislavmitin.domain.model.DomainAttraction
import ru.vladislavmitin.domain.model.DomainCity
import ru.vladislavmitin.domain.repository.AttractionsRepository
import ru.vladislavmitin.domain.repository.CitiesRepository

class GetCitiesWithAttractionsUseCaseImpl(
    private val citiesRepository: CitiesRepository,
    private val attractionsRepository: AttractionsRepository,
): GetCitiesWithAttractionsUseCase {
    override suspend fun getCitiesWithAttractions(): Map<DomainCity, List<DomainAttraction>> {
        return citiesRepository.getCities()
            .associateWith { attractionsRepository.getAttractionsByCity(it.id) }
    }
}