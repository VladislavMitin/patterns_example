package ru.vladislavmitin.patterns_example.di

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import ru.vladislavmitin.data.ApiLoggingService
import ru.vladislavmitin.data.ApiService
import ru.vladislavmitin.data.ApiServiceImpl
import ru.vladislavmitin.data.logging.ApiLogger
import ru.vladislavmitin.data.logging.LogCatLogger
import ru.vladislavmitin.data.repository.AttractionsRepositoryImpl
import ru.vladislavmitin.data.repository.CitiesRepositoryImpl
import ru.vladislavmitin.domain.repository.AttractionsRepository
import ru.vladislavmitin.domain.repository.CitiesRepository
import ru.vladislavmitin.domain.usecase.GetAttractionsUseCase
import ru.vladislavmitin.domain.usecase.GetAttractionsUseCaseImpl
import ru.vladislavmitin.domain.usecase.GetCitiesWithAttractionsUseCase
import ru.vladislavmitin.domain.usecase.GetCitiesWithAttractionsUseCaseImpl
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.delegates.AttractionAdapterDelegate
import ru.vladislavmitin.patterns_example.ui.attraction.AttractionsFragment
import ru.vladislavmitin.patterns_example.ui.attraction.AttractionsViewModel
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.model.BaseAttractionListItem
import ru.vladislavmitin.patterns_example.ui.attraction.adapter.delegates.CityAdapterDelegate
import ru.vladislavmitin.patterns_example.ui.model.NavigationMenu
import ru.vladislavmitin.patterns_example.R
import ru.vladislavmitin.patterns_example.ui.settings.SettingsFragment
import ru.vladislavmitin.patterns_example.ui.settings.SettingsViewModel
import ru.vladislavmitin.patterns_example.ui.ViewModelFactory
import ru.vladislavmitin.patterns_example.lazyUnsafe

object ApplicationDependenciesFactory {

    object DataLayer {
        val apiLogger: ApiLogger by lazyUnsafe { LogCatLogger() }
        val apiService: ApiService by lazyUnsafe { ApiServiceImpl() }
        val apiLoggingService: ApiService by lazyUnsafe { ApiLoggingService(apiService, apiLogger) }
    }

    object DomainLayer {
        val attractionsRepository: AttractionsRepository by lazyUnsafe {
            AttractionsRepositoryImpl(
                DataLayer.apiLoggingService
            )
        }
        val citiesRepository: CitiesRepository by lazyUnsafe { CitiesRepositoryImpl(DataLayer.apiLoggingService) }
        val getAttractionsUseCase: GetAttractionsUseCase by lazyUnsafe {
            GetAttractionsUseCaseImpl(
                attractionsRepository
            )
        }
        val getCitiesWithAttractionsUseCase: GetCitiesWithAttractionsUseCase by lazyUnsafe {
            GetCitiesWithAttractionsUseCaseImpl(
                citiesRepository,
                attractionsRepository
            )
        }
    }

    object PresentationLayer {
        val navigationMenu: List<NavigationMenu> by lazyUnsafe {
            listOf(
                NavigationMenu(
                    icon = R.drawable.ic_star,
                    name = R.string.navigation_menu_main,
                    { AttractionsFragment() },
                ),
                NavigationMenu(
                    icon = R.drawable.ic_settings,
                    name = R.string.navigation_menu_settings,
                    { SettingsFragment() },
                )
            )
        }

        val attractionsViewModelFactory: ViewModelFactory<AttractionsViewModel> by lazyUnsafe {
            ViewModelFactory {
                AttractionsViewModel(
                    DomainLayer.getAttractionsUseCase,
                    DomainLayer.getCitiesWithAttractionsUseCase,
                )
            }
        }

        val settingsViewModelFactory: ViewModelFactory<SettingsViewModel> by lazyUnsafe {
            ViewModelFactory {
                SettingsViewModel(

                )
            }
        }

        val delegatesProvider: List<AdapterDelegate<List<BaseAttractionListItem>>> by lazyUnsafe {
            listOf(
                AttractionAdapterDelegate(),
                CityAdapterDelegate(),
            )
        }
    }
}
