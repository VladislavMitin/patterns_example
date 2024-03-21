package ru.vladislavmitin.domain.usecase

import ru.vladislavmitin.domain.model.DomainAttraction
import ru.vladislavmitin.domain.repository.AttractionsRepository

class GetAttractionsUseCaseImpl(
    private val repository: AttractionsRepository
) : GetAttractionsUseCase {
    override suspend fun getAttractions(): List<DomainAttraction> {
        return repository.getAttractions()
    }
}