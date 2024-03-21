package ru.vladislavmitin.patterns_example.ui.attraction.adapter

import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.recyclerview.widget.RecyclerView
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem

abstract class BaseComposeAdapterDelegate<T : BaseAttractionListItem> :
    BaseAdapterDelegate<T, BaseComposeAdapterDelegate.ViewHolder<T>>() {

    @Composable
    abstract fun Content(item: T)

    override fun createViewHolder(parent: ViewGroup): ViewHolder<T> {
        return ViewHolder(
            view = ComposeView(parent.context),
            contentBuilder = {
                MaterialTheme {
                    Content(item = it)
                }
            }
        )
    }

    override fun onBindViewHolder(item: T, position: Int, holder: ViewHolder<T>) {
        holder.bind(item)
    }

    class ViewHolder<T>(
        val view: ComposeView,
        val contentBuilder: @Composable (T) -> Unit,
    ) : RecyclerView.ViewHolder(view) {
        private val data: MutableState<T?> = mutableStateOf(null)

        init {
            view.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool)
            view.setContent {
                data.value?.let {
                    contentBuilder(it)
                }
            }
        }

        fun bind(data: T) {
            this.data.value = data
        }
    }
}