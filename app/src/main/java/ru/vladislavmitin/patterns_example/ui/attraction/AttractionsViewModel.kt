package ru.vladislavmitin.patterns_example.ui.attraction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vladislavmitin.domain.usecase.GetAttractionsUseCase
import ru.vladislavmitin.domain.usecase.GetCitiesWithAttractionsUseCase
import ru.vladislavmitin.patterns_example.ui.model.AttractionLoadStrategy
import ru.vladislavmitin.patterns_example.ui.model.toPresentation

class AttractionsViewModel(
    private val getAttractionsUseCase: GetAttractionsUseCase,
    private val getCitiesWithAttractionsUseCase: GetCitiesWithAttractionsUseCase
) : ViewModel() {
    val state: MutableStateFlow<List<Any>> = MutableStateFlow(emptyList())

    fun load(strategy: AttractionLoadStrategy) {
        viewModelScope.launch {
            when (strategy) {
                AttractionLoadStrategy.ONLY_ATTRACTION -> {
                    state.value = getAttractionsUseCase.getAttractions().map { it.toPresentation() }
                }

                AttractionLoadStrategy.CITY_ATTRACTION -> {
                    state.value =
                        getCitiesWithAttractionsUseCase.getCitiesWithAttractions().flatMap {
                            listOf(it.key.toPresentation()) + it.value.map { it.toPresentation() }
                        }
                }
            }
        }
    }
}