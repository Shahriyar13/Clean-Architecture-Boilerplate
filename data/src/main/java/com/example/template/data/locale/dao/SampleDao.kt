package com.example.template.data.locale.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.template.data.locale.entity.SampleData

@Dao
interface SampleDao: BaseDao<SampleData> {
    @Query("SELECT id FROM SampleTable")
    suspend fun selectAllIds(): List<Long>?

    @Query("SELECT * FROM SampleTable")
    suspend fun select(): List<SampleData>?

    @Query("SELECT * FROM SampleTable WHERE name Like :name")
    suspend fun selectByName(name: String): List<SampleData>?

    @Query("SELECT * FROM SampleTable WHERE id = :id")
    suspend fun selectById(id: Long): List<SampleData>?

    @Query("DELETE FROM SampleTable")
    suspend fun truncate()
}