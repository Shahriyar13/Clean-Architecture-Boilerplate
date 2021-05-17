package com.example.template.data.locale.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    suspend fun insert(t: T)

    @Insert(onConflict = REPLACE)
    suspend fun insert(ts: List<T>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIgnoreOnConflict(data : T)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateIgnoreOnConflict(data : T)

    @Update(onConflict = REPLACE)
    suspend fun update(t: T): Int

    @Update(onConflict = REPLACE)
    suspend fun update(ts: List<T>)

    @Delete
    suspend fun delete(t: T)

    @Delete
    suspend fun delete(ts: List<T>)

}