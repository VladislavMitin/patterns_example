package ru.vladislavmitin.patterns_example.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

class NavigationMenu(
    @DrawableRes val icon: Int,
    @StringRes val name: Int,
    val fragmentProvider: () -> Fragment,
)