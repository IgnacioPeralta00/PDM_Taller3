package com.pdmcourse2026.RankeUca.ui.screens.home

import com.pdmcourse2026.RankeUca.models.Option

data class HomeUiState(
    val options : List<Option> = emptyList(),
    val loading : Boolean = false,
    val error : String? = null,
    val isRefreshing : Boolean = false
)
