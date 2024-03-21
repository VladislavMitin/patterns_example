package ru.vladislavmitin.data.dto

import ru.vladislavmitin.domain.model.DomainCity
import java.util.Locale

class ApiCity(
    val id: Int,
    val name: String,
    val population: Long,
    val url: String,
)

fun ApiCity.toDomain() = DomainCity(
    id = id,
    name = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
    population = population,
    url = url,
)