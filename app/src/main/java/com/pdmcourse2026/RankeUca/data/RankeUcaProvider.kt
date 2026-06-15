package com.pdmcourse2026.RankeUca.data

import android.content.Context
import com.pdmcourse2026.RankeUca.data.local.RankeUcaDatabase
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepository
import com.pdmcourse2026.RankeUca.data.repositories.OptionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = RankeUcaDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}