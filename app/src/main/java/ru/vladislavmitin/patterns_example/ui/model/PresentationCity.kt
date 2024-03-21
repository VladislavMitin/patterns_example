package ru.vladislavmitin.patterns_example.ui.model

import ru.vladislavmitin.domain.model.DomainCity

class PresentationCity(
    val id: Int,
    val name: String,
    val population: Long,
    val url: String,
)

fun DomainCity.toPresentation() = PresentationCity(
    id = id,
    name = name,
    population = population,
    url = url,
)