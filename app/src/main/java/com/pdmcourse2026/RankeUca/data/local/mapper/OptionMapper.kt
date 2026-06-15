package com.pdmcourse2026.RankeUca.data.local.mapper

import com.pdmcourse2026.RankeUca.data.local.entities.OptionEntity
import com.pdmcourse2026.RankeUca.domain.models.Option

fun OptionEntity.toModel(): Option {
    return Option(
        id = id,
        name = name,
        imageUrl = imageUrl,
    )
}

fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}