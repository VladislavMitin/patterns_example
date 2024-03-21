package ru.vladislavmitin.patterns_example.ui.settings

import android.view.LayoutInflater
import ru.vladislavmitin.patterns_example.MyApplication
import ru.vladislavmitin.patterns_example.databinding.SettingsFragmentBinding
import ru.vladislavmitin.patterns_example.ui.BaseFragment

class SettingsFragment: BaseFragment<SettingsFragmentBinding, SettingsViewModel>(SettingsViewModel::class) {
    override fun inject() {
        (requireActivity().application as MyApplication).applicationInjector.inject(this)
    }

    override fun createViewBinding(layoutInflater: LayoutInflater) = SettingsFragmentBinding.inflate(layoutInflater)
}