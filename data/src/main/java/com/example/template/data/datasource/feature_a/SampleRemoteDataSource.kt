package com.example.template.data.datasource.feature_a

import com.example.template.data.datasource.BaseDataSource
import com.example.template.domain.common.MResult
import com.example.template.domain.entity.feature_a.SampleEntity

interface SampleRemoteDataSource: BaseDataSource {
    suspend fun setSample(sampleEntity: SampleEntity): MResult<Boolean>
    suspend fun getSample(): MResult<List<SampleEntity>>
}