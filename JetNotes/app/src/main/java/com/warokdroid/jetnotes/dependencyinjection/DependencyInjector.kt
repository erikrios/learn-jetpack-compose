package com.warokdroid.jetnotes.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.warokdroid.jetnotes.data.database.AppDatabase
import com.warokdroid.jetnotes.data.database.dbmapper.DbMapper
import com.warokdroid.jetnotes.data.database.dbmapper.DbMapperImpl
import com.warokdroid.jetnotes.data.repository.Repository
import com.warokdroid.jetnotes.data.repository.RepositoryImpl

/**
 * Provides dependencies across the app.
 */
class DependencyInjector(applicationContext: Context) {

    val repository: Repository by lazy { provideRepository(database) }

    private val database: AppDatabase by lazy { provideDatabase(applicationContext) }

    private val dbMapper: DbMapper = DbMapperImpl()

    private fun provideDatabase(applicationContext: Context): AppDatabase =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()

    private fun provideRepository(database: AppDatabase): Repository {
        val noteDao = database.noteDao()
        val colorDao = database.colorDao()

        return RepositoryImpl(noteDao, colorDao, dbMapper)
    }
}
