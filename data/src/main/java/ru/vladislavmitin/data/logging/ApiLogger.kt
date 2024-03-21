package ru.vladislavmitin.data.logging

interface ApiLogger {
    fun log(tag: String, method: String, millis: Long)
}