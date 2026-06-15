package com.pdmcourse2026.RankeUca.models

data class Option(
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val votes: Int? = null
)
