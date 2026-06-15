package com.pdmcourse2026.RankeUca.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequestDto(
    val optionId : Int
)

@Serializable
data class PostResponseDto(
    val ok : Boolean,
    val message : String
)
