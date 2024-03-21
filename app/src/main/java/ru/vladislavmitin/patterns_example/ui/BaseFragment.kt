package ru.vladislavmitin.patterns_example.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewBinding, VM: ViewModel>(vmClass: KClass<VM>) : Fragment() {

    protected lateinit var viewBinding: VB

    lateinit var viewModelFactory: ViewModelFactory<VM>

    protected val viewModel: VM by createViewModelLazy(
        viewModelClass = vmClass,
        storeProducer = { viewModelStore },
        factoryProducer = { viewModelFactory },
    )

    abstract fun inject()

    abstract fun createViewBinding(layoutInflater: LayoutInflater): VB

    @CallSuper
    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = createViewBinding(inflater)
        return viewBinding.root
    }

    protected fun <T> Flow<T>.observe(action: (T) -> Unit) {
        lifecycleScope.launch {
            collect { action(it) }
        }
    }
}