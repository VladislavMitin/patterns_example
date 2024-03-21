package ru.vladislavmitin.patterns_example.ui

import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.vladislavmitin.patterns_example.MyApplication
import ru.vladislavmitin.patterns_example.ui.model.NavigationMenu
import ru.vladislavmitin.patterns_example.databinding.MainActivityBinding
import ru.vladislavmitin.patterns_example.lazyUnsafe

class MainActivity : FragmentActivity() {

    private lateinit var viewBinding: MainActivityBinding

    lateinit var navigationMenu: List<NavigationMenu>

    private val adapter: FragmentStateAdapter by lazyUnsafe {
        object : FragmentStateAdapter(this) {
            override fun getItemCount() = navigationMenu.size
            override fun createFragment(position: Int) = navigationMenu[position].fragmentProvider()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).applicationInjector.inject(this)
        super.onCreate(savedInstanceState)
        viewBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initNavigationView()
        initViewPager()
    }

    private fun initNavigationView() {
        with(viewBinding) {
            navigationMenu.forEachIndexed { index, navigationMenu ->
                bottomNavigationView.menu.add(
                    Menu.NONE,
                    index,
                    Menu.NONE,
                    navigationMenu.name
                ).setIcon(navigationMenu.icon)
            }

            bottomNavigationView.setOnItemSelectedListener { item ->
                viewPager.setCurrentItem(item.itemId, false)
                true
            }
        }
    }

    private fun initViewPager() {
        with(viewBinding) {
            viewPager.offscreenPageLimit = navigationMenu.size - 1
            viewPager.adapter = adapter
        }
    }
}