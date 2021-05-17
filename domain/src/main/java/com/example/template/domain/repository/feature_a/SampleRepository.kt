package com.example.template.domain.repository.feature_a

import com.example.template.domain.common.MResult
import com.example.template.domain.entity.feature_a.SampleEntity
import com.example.template.domain.repository.BaseRepository

interface SampleRepository: BaseRepository {
    suspend fun setData(sampleEntity: SampleEntity)
    suspend fun getData() : MResult<List<SampleEntity>>
}