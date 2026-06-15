package com.pdmcourse2026.RankeUca.data.repositories

import com.pdmcourse2026.RankeUca.models.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    suspend fun getPlaces(): Result<List<Option>>

    suspend fun votePlace(placeId: Int): Result<Boolean>

    fun getOptions(): Flow<List<Option>>

    suspend fun addOption(option: Option)

    suspend fun deleteOption(option: Option)
}