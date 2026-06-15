package com.pdmcourse2026.RankeUca.data.repositories

import com.pdmcourse2026.RankeUca.models.Place

interface PlaceRepository {
    suspend fun getPlaces(): Result<List<Place>>
    suspend fun votePlace(placeId: Int): Result<Boolean>
}