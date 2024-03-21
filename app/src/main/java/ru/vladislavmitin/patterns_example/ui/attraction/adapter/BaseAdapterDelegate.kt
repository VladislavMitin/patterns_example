package ru.vladislavmitin.patterns_example.ui.attraction.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem

abstract class BaseAdapterDelegate<T: BaseAttractionListItem, Holder : RecyclerView.ViewHolder> : AdapterDelegate<List<BaseAttractionListItem>>() {

    abstract fun isForViewType(item: BaseAttractionListItem): Boolean

    abstract fun createViewHolder(parent: ViewGroup): Holder

    abstract fun onBindViewHolder(item: T, position: Int, holder: Holder)

    override fun isForViewType(items: List<BaseAttractionListItem>, position: Int): Boolean {
        val item = items[position]
        return isForViewType(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return createViewHolder(parent)
    }

    override fun onBindViewHolder(
        items: List<BaseAttractionListItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        onBindViewHolder(items[position] as T, position, holder as Holder)
    }
}