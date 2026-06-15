package com.pdmcourse2026.RankeUca.data.repositories

import com.pdmcourse2026.RankeUca.domain.models.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestions(): Flow<List<Question>>
    suspend fun addQuestion(title: String)
    suspend fun deleteQuestion(question: Question)
}