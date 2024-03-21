package ru.vladislavmitin.patterns_example

import android.app.Application
import ru.vladislavmitin.patterns_example.di.ApplicationDependenciesFactory
import ru.vladislavmitin.patterns_example.di.ApplicationInjector

class MyApplication: Application() {

    lateinit var applicationInjector: ApplicationInjector

    override fun onCreate() {
        super.onCreate()

        applicationInjector = ApplicationInjector(
            context = applicationContext,
            navigationMenuProvider = { ApplicationDependenciesFactory.PresentationLayer.navigationMenu },
            attractionsViewModelFactory = { ApplicationDependenciesFactory.PresentationLayer.attractionsViewModelFactory },
            settingsViewModelFactory = { ApplicationDependenciesFactory.PresentationLayer.settingsViewModelFactory },
            delegatesProvider = { ApplicationDependenciesFactory.PresentationLayer.delegatesProvider },
        )
    }
}