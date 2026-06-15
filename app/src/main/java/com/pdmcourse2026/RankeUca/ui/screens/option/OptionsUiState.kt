package com.pdmcourse2026.RankeUca.ui.screens.option

import com.pdmcourse2026.RankeUca.models.Option

data class OptionsUiState(
    val options : List<Option> = emptyList(),
    val loading : Boolean = false,
    val error : String? = null,
    val isRefreshing : Boolean = false
)
