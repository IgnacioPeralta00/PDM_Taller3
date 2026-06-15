package com.pdmcourse2026.RankeUca.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "options")
data class OptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
)