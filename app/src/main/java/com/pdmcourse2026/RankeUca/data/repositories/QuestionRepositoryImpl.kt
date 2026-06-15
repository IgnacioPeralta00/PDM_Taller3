package com.pdmcourse2026.RankeUca.data.repositories

import com.pdmcourse2026.RankeUca.data.local.dao.QuestionDao
import com.pdmcourse2026.RankeUca.data.local.entities.QuestionEntity
import com.pdmcourse2026.RankeUca.data.local.mapper.toEntity
import com.pdmcourse2026.RankeUca.data.local.relation.toModel
import com.pdmcourse2026.RankeUca.domain.models.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(
    private val questionDao: QuestionDao
) : QuestionRepository {

    override fun getQuestions(): Flow<List<Question>> {
        return questionDao.getQuestionsWithOptions().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun addQuestion(title: String) {
        questionDao.insertQuestion(QuestionEntity(title = title))
    }

    override suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question.toEntity())
    }
}