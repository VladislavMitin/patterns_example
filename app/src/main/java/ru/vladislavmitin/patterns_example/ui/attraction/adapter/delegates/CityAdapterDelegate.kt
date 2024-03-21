package ru.vladislavmitin.patterns_example.ui.attraction.adapter.delegates

import androidx.compose.runtime.Composable
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.CityListItem
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.BaseComposeAdapterDelegate
import ru.vladislavmitin.patterns_example.ui.attraction.compose.CityCard

class CityAdapterDelegate: BaseComposeAdapterDelegate<CityListItem>() {
    @Composable
    override fun Content(item: CityListItem) {
        CityCard(city = item.city)
    }

    override fun isForViewType(item: BaseAttractionListItem) = item is CityListItem
}