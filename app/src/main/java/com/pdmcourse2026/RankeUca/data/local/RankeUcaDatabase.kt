package com.pdmcourse2026.RankeUca.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdmcourse2026.RankeUca.data.local.dao.OptionDao
import com.pdmcourse2026.RankeUca.data.local.dao.QuestionDao
import com.pdmcourse2026.RankeUca.data.local.entities.OptionEntity
import com.pdmcourse2026.RankeUca.data.local.entities.QuestionEntity

@Database(
    entities = [QuestionEntity::class, OptionEntity::class],
    version = 2,
    exportSchema = false
)
abstract class RankeUcaDatabase : RoomDatabase() {

    abstract fun optionDao(): OptionDao
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var INSTANCE: RankeUcaDatabase? = null

        fun getDatabase(context: Context): RankeUcaDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = RankeUcaDatabase::class.java,
                    name = "rankeuca_database"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}