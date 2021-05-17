package com.example.template.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.template.data.locale.dao.SampleDao
import com.example.template.data.locale.entity.SampleData

@Database(
    entities = [
        SampleData::class,
    ],
    version = 2,
    exportSchema = false
)

@TypeConverters(TypeConverter::class)
abstract class MDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}