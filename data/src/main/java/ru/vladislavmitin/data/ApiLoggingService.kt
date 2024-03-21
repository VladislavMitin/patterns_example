package ru.vladislavmitin.data

import ru.vladislavmitin.data.dto.ApiAttraction
import ru.vladislavmitin.data.dto.ApiCity
import ru.vladislavmitin.data.logging.ApiLogger

class ApiLoggingService(
    private val apiService: ApiService,
    private val apiLogger: ApiLogger,
): ApiService {
    override suspend fun getCities(): List<ApiCity> {
        return loggingCall("getCities") {
            apiService.getCities()
        }
    }

    override suspend fun getAttractionsByCity(cityId: Int): List<ApiAttraction> {
        return loggingCall("getAttractionsByCity") {
            apiService.getAttractionsByCity(cityId)
        }
    }

    override suspend fun getAttractions(): List<ApiAttraction> {
        return loggingCall("getAttractions") {
            apiService.getAttractions()
        }
    }

    private suspend fun <T> loggingCall(method: String, block: suspend () -> T): T {
        val startTime = System.currentTimeMillis()

        return block().apply {
            val spentTime = System.currentTimeMillis() - startTime
            apiLogger.log(TAG, method, spentTime)
        }
    }

    private companion object {
        const val TAG: String = "ApiLoggingService"
    }
}