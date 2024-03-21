package ru.vladislavmitin.patterns_example.ui.attraction.adapter

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem

class AttractionListDelegationAdapter: ListDelegationAdapter<List<BaseAttractionListItem>>() {
    fun initDelegates(delegates: List<AdapterDelegate<List<BaseAttractionListItem>>>) {
        delegates.forEachIndexed { index, delegate ->
            delegatesManager.addDelegate(index, true, delegate)
        }
    }
}