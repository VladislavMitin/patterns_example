package ru.vladislavmitin.domain.usecase

import ru.vladislavmitin.domain.model.DomainAttraction

interface GetAttractionsUseCase {
    suspend fun getAttractions(): List<DomainAttraction>
}