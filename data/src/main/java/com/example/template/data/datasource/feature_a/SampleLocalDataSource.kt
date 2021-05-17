package com.example.template.data.datasource.feature_a

import com.example.template.data.datasource.BaseDataSource
import com.example.template.domain.entity.feature_a.SampleEntity

interface SampleLocalDataSource: BaseDataSource {
    suspend fun setSample(sampleEntity: SampleEntity)
    suspend fun setSample(sampleEntities: List<SampleEntity>)
    suspend fun getSample(): List<SampleEntity>
    suspend fun deleteAll()
}