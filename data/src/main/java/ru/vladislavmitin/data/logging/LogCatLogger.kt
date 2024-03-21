package ru.vladislavmitin.data.logging

import android.annotation.SuppressLint
import android.util.Log

class LogCatLogger: ApiLogger {
    @SuppressLint("LogNotTimber")
    override fun log(tag: String, method: String, millis: Long) {
        Log.d(tag, "Api method $method took $millis millis")
    }
}