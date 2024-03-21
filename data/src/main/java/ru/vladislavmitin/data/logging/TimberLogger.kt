package ru.vladislavmitin.data.logging

import timber.log.Timber

class TimberLogger: ApiLogger {
    override fun log(tag: String, method: String, millis: Long) {
        Timber.tag(tag).d("Api method $method took $millis millis")
    }
}