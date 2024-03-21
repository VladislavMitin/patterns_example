package ru.vladislavmitin.patterns_example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class ViewModelFactory<VM: ViewModel>(
    private val provider: () -> VM,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return provider() as T
    }
}