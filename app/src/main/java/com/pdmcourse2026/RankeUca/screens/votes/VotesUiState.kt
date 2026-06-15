package com.pdmcourse2026.RankeUca.screens.votes

import com.pdmcourse2026.RankeUca.models.Place

data class VotesUiState(
    val places : List<Place> = emptyList(),
    val loading : Boolean = false,
    val error : String? = null,
    val isRefreshing : Boolean = false
)
