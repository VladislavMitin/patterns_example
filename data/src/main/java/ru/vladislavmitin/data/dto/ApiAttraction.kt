package ru.vladislavmitin.data.dto

import ru.vladislavmitin.domain.model.DomainAttraction
import java.util.Locale

class ApiAttraction(
    val id: Int,
    val cityId: Int,
    val name: String,
    val description: String,
    val rating: String,
    val url: String,
)

fun ApiAttraction.toDomain() = DomainAttraction(
    name = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
    description = description,
    rating = rating,
    url = url,
)