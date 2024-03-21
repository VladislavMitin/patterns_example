package ru.vladislavmitin.patterns_example

fun <T> lazyUnsafe(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)
