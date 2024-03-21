package ru.vladislavmitin.patterns_example.ui.model

import ru.vladislavmitin.domain.model.DomainAttraction

data class PresentationAttraction(
    val name: String,
    val description: String,
    val rating: String,
    val url: String,
)

fun DomainAttraction.toPresentation() = PresentationAttraction(
    name = name,
    description = description,
    rating = rating,
    url = url,
)