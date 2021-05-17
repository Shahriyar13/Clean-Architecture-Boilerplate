package com.example.template.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.template.data.locale.MDatabase
import com.example.template.data.locale.dao.SampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMDatabase(@ApplicationContext context: Context): MDatabase {
        val migrationV1ToV2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE SampleTable ADD COLUMN name TEXT DEFAULT '' NOT NULL")
            }
        }

        return Room.databaseBuilder(context, MDatabase::class.java, "mDB")
            .addMigrations(
                migrationV1ToV2
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideSampleDao(mDatabase: MDatabase): SampleDao = mDatabase.sampleDao()

}