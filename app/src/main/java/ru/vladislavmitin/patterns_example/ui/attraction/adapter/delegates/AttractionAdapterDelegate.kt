package ru.vladislavmitin.patterns_example.ui.attraction.adapter.delegates

import androidx.compose.runtime.Composable
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.AttractionListItem
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.BaseComposeAdapterDelegate
import ru.vladislavmitin.patterns_example.ui.attraction.compose.AttractionCard

class AttractionAdapterDelegate : BaseComposeAdapterDelegate<AttractionListItem>() {
    @Composable
    override fun Content(item: AttractionListItem) {
        AttractionCard(attraction = item.attraction)
    }

    override fun isForViewType(item: BaseAttractionListItem) = item is AttractionListItem
}