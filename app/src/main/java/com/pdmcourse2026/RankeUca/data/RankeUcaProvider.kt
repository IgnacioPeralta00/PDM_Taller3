package com.pdmcourse2026.RankeUca.data

import android.content.Context
import com.pdmcourse2026.RankeUca.data.local.RankeUcaDatabase
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepository
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepositoryImpl
import com.pdmcourse2026.RankeUca.data.repositories.QuestionRepository
import com.pdmcourse2026.RankeUca.data.repositories.QuestionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = RankeUcaDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()
    private val questionDao = appDatabase.questionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }

    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }
}