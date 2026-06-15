package com.pdmcourse2026.RankeUca.data.local.mapper

import com.pdmcourse2026.RankeUca.data.local.entities.QuestionEntity
import com.pdmcourse2026.RankeUca.domain.models.Question

fun QuestionEntity.toModel(): Question {
    return Question(
        id = id,
        title = title,
        optionCount = 0,
    )
}

fun Question.toEntity(): QuestionEntity {
    return QuestionEntity(
        id = id,
        title = title,
    )
}