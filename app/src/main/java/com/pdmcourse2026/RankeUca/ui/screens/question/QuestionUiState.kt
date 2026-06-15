package com.pdmcourse2026.RankeUca.ui.screens.question

import com.pdmcourse2026.RankeUca.domain.models.Option

data class QuestionUiState(
    val options : List<Option> = emptyList(),
    val loading : Boolean = false,
    val error : String? = null,
    val isRefreshing : Boolean = false
)
