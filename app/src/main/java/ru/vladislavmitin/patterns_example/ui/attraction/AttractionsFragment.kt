package ru.vladislavmitin.patterns_example.ui.attraction

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.AttractionListItem
import ru.vladislavmitin.patterns_example.ui.model.AttractionLoadStrategy
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.CityListItem
import ru.vladislavmitin.patterns_example.MyApplication
import ru.vladislavmitin.patterns_example.databinding.AttractionsFragmentBinding
import ru.vladislavmitin.patterns_example.lazyUnsafe
import ru.vladislavmitin.patterns_example.ui.BaseFragment
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.AttractionListDelegationAdapter
import ru.vladislavmitin.patterns_example.ui.model.PresentationAttraction
import ru.vladislavmitin.patterns_example.ui.model.PresentationCity

class AttractionsFragment :
    BaseFragment<AttractionsFragmentBinding, AttractionsViewModel>(AttractionsViewModel::class) {

    lateinit var delegatesProvider: () -> List<AdapterDelegate<List<BaseAttractionListItem>>>

    private val adapter by lazyUnsafe { AttractionListDelegationAdapter() }

    override fun inject() {
        (requireActivity().application as MyApplication).applicationInjector.inject(this)
    }

    override fun createViewBinding(layoutInflater: LayoutInflater) =
        AttractionsFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()

        viewModel.state.observe(::render)
    }

    override fun onResume() {
        super.onResume()
        viewModel.load(AttractionLoadStrategy.CITY_ATTRACTION)
    }

    private fun initRecyclerView() {
        with(viewBinding) {
            adapter.initDelegates(delegatesProvider())

            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun render(state: List<Any>) {
        adapter.items = listItems(state)
        adapter.notifyDataSetChanged()
    }

    private fun listItems(list: List<Any>): List<BaseAttractionListItem> {
        return list.mapNotNull {
            when (it) {
                is PresentationAttraction -> AttractionListItem(it)
                is PresentationCity -> CityListItem(it)
                else -> null
            }
        }
    }
}