package ru.vladislavmitin.patterns_example.di

import android.content.Context
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import ru.vladislavmitin.patterns_example.ui.attraction.AttractionsFragment
import ru.vladislavmitin.patterns_example.ui.attraction.AttractionsViewModel
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem
import ru.vladislavmitin.patterns_example.ui.MainActivity
import ru.vladislavmitin.patterns_example.ui.model.NavigationMenu
import ru.vladislavmitin.patterns_example.ui.settings.SettingsFragment
import ru.vladislavmitin.patterns_example.ui.settings.SettingsViewModel
import ru.vladislavmitin.patterns_example.ui.ViewModelFactory

class ApplicationInjector(
    private val context: Context,
    private val navigationMenuProvider: () -> List<NavigationMenu>,
    private val attractionsViewModelFactory: () -> ViewModelFactory<AttractionsViewModel>,
    private val settingsViewModelFactory: () -> ViewModelFactory<SettingsViewModel>,
    private val delegatesProvider: () -> List<AdapterDelegate<List<BaseAttractionListItem>>>,
) {
    fun inject(mainActivity: MainActivity) {
        mainActivity.navigationMenu = navigationMenuProvider()
    }

    fun inject(attractionsFragment: AttractionsFragment) {
        attractionsFragment.viewModelFactory = attractionsViewModelFactory()
        attractionsFragment.delegatesProvider = delegatesProvider
    }

    fun inject(settingsFragment: SettingsFragment) {
        settingsFragment.viewModelFactory = settingsViewModelFactory()
    }
}